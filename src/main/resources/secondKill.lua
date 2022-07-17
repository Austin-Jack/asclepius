-- 获取传入的两个参数
-- 例如cardId = 10 sid = sid_102
local cardId = KEYS[1]
local sid = KEYS[2]
-- 拼接字符串 结果为 que_sid_102
local queue = 'que_' .. sid
-- 拼接 结果为 sid_102_records	作为一个集合的key记录已经预约了该班次的cid集合
local record = sid .. '_records'
-- 声明一个table变量
local res = {}
-- 执行redis命令 查看该cid是否已经存在于该班次已抢集合中
local userExists = redis.call('sismember', record, cardId)
-- 如果存在则返回-2 表示不能重复挂号
if tonumber(userExists) == 1 then
    res[1] = -2
    return res
end
-- 获取sid_102对应剩余的可预约数
local num = redis.call('get', sid)
-- 如果小于等于0了说明被抢完了返回-1
if num == nil or tonumber(num) <= 0 then
    res[1] = -1
    return res
    --  其他情况则执行抢号操作
else
    -- 将sid_102对应的剩余数减一
    redis.call('decr', sid)
    -- 	将当前的cid例如10号加入到班次已定集合sid_102_records中
    redis.call('sadd', record, cardId)
    -- 	获取预约号 表示第几位抢到的
    redis.call('incr', queue)
end
-- 获取剩余的可抢数量  用于返回给前端
res[1] = num - 1
-- 获取当前这个预约号
res[2] = redis.call('get', queue)
-- 返回结果
print(cardId, sid)
return res
