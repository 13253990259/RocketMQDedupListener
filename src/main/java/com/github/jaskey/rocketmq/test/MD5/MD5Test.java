package com.github.jaskey.rocketmq.test.MD5;

import com.github.jaskey.rocketmq.test.response.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MD5Test {

    private static Logger logger = LoggerFactory.getLogger(MD5Test.class);

    public static void main(String[] args) {
        String str = "{\"{$v1}\":\"苏星河\",\"{$v2}\":\"刘冠星\"}";
        List<Map<String, String>> maps = paramJsonToValueListStr(str);
        System.out.println(maps);

        System.out.println("第一次新增");

        System.out.println("第二次新增");

        System.out.println("第三次新增");

        System.out.println("第四次新增");
    }

    protected static List<Map<String, String>> paramJsonToValueListStr(String paramJson) {
        List<Map<String, String>> vars = new ArrayList<>();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(paramJson)) {
            Map<String, Object> parseJson = JsonUtils.parseJson(paramJson, Map.class);
            if (!parseJson.isEmpty()) {
                Map<String, String> paramMap = parseJson.entrySet().stream().collect(
                        Collectors.toMap(
                                entry -> unwrapVar(entry.getKey()),
                                entry -> String.valueOf(entry.getValue()),
                                (o1, o2) -> o2));

                vars.add(paramMap);
            }
        }
        System.out.println("ahhahahhaha");
        return vars;
    }

    private static String unwrapVar(String s) {
        return org.apache.commons.lang3.StringUtils.removeEnd(org.apache.commons.lang3.StringUtils.removeStart(s, "{$"), "}");
    }
}
