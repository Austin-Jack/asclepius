local cardId = KEYS[1]
local sid = KEYS[2]
local record = sid .. '_records'
local userExists = redis.call('sismember', record, cardId)
if tonumber(userExists) == 0 then
    return 2
end
redis.call('incr', sid)
redis.call('srem', record, cardId)
return 1