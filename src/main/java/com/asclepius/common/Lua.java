package com.asclepius.common;

@Deprecated
public interface Lua {
    String SECOND_KILL = "local cardid=KEYS[1]; \n" +
            "local sid=KEYS[2];\n" +
            "local queue=\"que_\"..sid\n" +
            "local prore=sid..\"_records\"; \n" +
            "local res={} \n" +
            "local userExists=redis.call(\"sismember\",prore,cardid);\n" +
            "if tonumber(userExists)==1 then \n" +
            "\tres[1]=-2;\n" +
            "  return res;\n" +
            "end\n" +
            "local num=redis.call(\"get\",sid);\n" +
            "if tonumber(num)<=0 then \n" +
            "\tres[1]=-1;\n" +
            "  return res; \n" +
            "else \n" +
            "  redis.call(\"decr\",sid);\n" +
            "  redis.call(\"sadd\",prore,cardid);\n" +
            "  redis.call(\"incr\",queue)\n" +
            "end\n" +
            "res[1]=num-1;\n" +
            "res[2]=redis.call(\"get\",queue)\n" +
            "return res;";

    String CANCEL = "local cardid=KEYS[1]; \n" +
            "local sid=KEYS[2];\n" +
            "local prore=sid..\"_records\"; \n" +
            "local userExists=redis.call(\"sismember\",prore,cardid);\n" +
            "if tonumber(userExists)==0 then \n" +
            "  return 2;\n" +
            "end\n" +
            "redis.call(\"incr\",sid);\n" +
            "redis.call(\"srem\",prore,cardid)\n" +
            "return 1";
}
