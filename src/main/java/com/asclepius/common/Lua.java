package com.asclepius.common;

public interface Lua {
    String SECOND_KILL = "local cardid=KEYS[1]; \n" +
            "local sid=KEYS[2];\n" +
            "local prore=sid..\"_records\"; \n" +
            "local userExists=redis.call(\"sismember\",prore,cardid);\n" +
            "if tonumber(userExists)==1 then \n" +
            "  return -2;\n" +
            "end\n" +
            "local num=redis.call(\"get\",sid);\n" +
            "if tonumber(num)<=0 then \n" +
            "  return -1; \n" +
            "else \n" +
            "  redis.call(\"decr\",sid);\n" +
            "  redis.call(\"sadd\",prore,cardid);\n" +
            "end\n" +
            "return num-1;";
}
