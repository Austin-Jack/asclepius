local cardId = KEYS[1]
local sid = KEYS[2]
local record = sid .. '_records'
local queue = 'que_' .. sid
local userExists = redis.call('sismember', record, cardId)
if tonumber(userExists) == 0 then
    return 2
end
redis.call('incr', sid)
redis.call('srem', record, cardId)
redis.call('decr', queue)
return 1