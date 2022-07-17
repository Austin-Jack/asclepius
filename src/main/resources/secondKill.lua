-- 获取传入的两个参数
-- 例如cardId = cId_10 key = sid_102
local hashKey = KEYS[1]
local filedKey = KEYS[2]
-- 声明一个table变量
local res = {}
-- 执行redis命令 查看该cid是否已经存在于该班次的hash中
local reserved = redis.call('HEXISTS', hashKey, filedKey)
-- 如果存在则返回-2 表示不能重复挂号
if tonumber(reserved) == 1 then
    res[1] = -2
    return res
end
-- 获取sid_102对应剩余的可预约数
local remain = redis.call('HGET', hashKey, 'remain')
-- nil说明这个hash就不存在（非正常用户触发） 如果小于等于0了说明被抢完了返回-1
if remain == nil or tonumber(remain) <= 0 then
    res[1] = -1
    return res
    --  其他情况则执行抢号操作
else
    local total = redis.call('HGET', hashKey, 'total')
    -- 将sid_102对应的剩余数减一 得到最新的剩余数
    remain = redis.call('HINCRBY', hashKey, 'remain', -1)
    -- 	将当前的cid例如10号加入到班次hash中作为key值 value对应其预约号
    redis.call('HSET', hashKey, filedKey, total - remain)
    -- 获取剩余的可抢数量  用于返回给前端
    res[1] = remain
    -- 获取当前这个预约号
    res[2] = total - remain
    -- 返回结果
    return res
end

