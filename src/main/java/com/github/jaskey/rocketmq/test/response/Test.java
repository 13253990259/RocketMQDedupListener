package com.github.jaskey.rocketmq.test.response;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {

        DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMDDHHmmss");
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("GMT+8")).toLocalDateTime();
        String format = localDateTime.format(DAY_FORMATTER);
        System.out.println(format);

        String body = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"mmsId\": 554\n" +
                "    }\n" +
                "}";



        /*Gson gson = new Gson();

        TypeToken<BaseResponse<KuanxinYDCreateTemplateResponse>> typeToken = new TypeToken<BaseResponse<KuanxinYDCreateTemplateResponse>>() {};
        BaseResponse<KuanxinYDCreateTemplateResponse> o = gson.fromJson(body, typeToken.getType());
        System.out.println(o);*/

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        try {
            BaseResponse<KuanxinYDCreateTemplateResponse> response = objectMapper.readValue(body, typeFactory.constructParametricType(BaseResponse.class, KuanxinYDCreateTemplateResponse.class));

            System.out.println("Code: " + response.getCode());
            System.out.println("Data: " + response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static <T> T converter(String body, Class<T> clazz) {

        return JsonUtils.parseJson(body, clazz);
    }
}
