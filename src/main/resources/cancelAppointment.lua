local hashKey = KEYS[1]
local filedKey = KEYS[2]
-- 执行redis命令 查看该cid是否已经存在于该班次的hash中
local reserved = redis.call('HEXISTS', hashKey, filedKey)
-- 如果不存在说明没有预约 返回-1
if tonumber(reserved) == 0 then
    return -1
end
redis.call('HINCRBY', hashKey, 'remain', 1)
local res =  redis.call('HDEL', hashKey, filedKey)
return tonumber(res)