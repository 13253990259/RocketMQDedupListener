package com.github.jaskey.rocketmq.test.response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static ObjectMapper DATE_FORMAT_INSTANCE = new ObjectMapper();

    public JsonUtils() {
    }

    public static String toJsonStr(Object obj) {
        try {
            return DATE_FORMAT_INSTANCE.writeValueAsString(obj);
        } catch (JsonGenerationException var2) {
            throw new RuntimeException(var2);
        } catch (JsonMappingException var3) {
            throw new RuntimeException(var3);
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }


    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return DATE_FORMAT_INSTANCE.readValue(json, clazz);
        } catch (JsonParseException var3) {
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }

    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            return (List)DATE_FORMAT_INSTANCE.readValue(json, javaType);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return DATE_FORMAT_INSTANCE.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    static {
        DATE_FORMAT_INSTANCE.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        DATE_FORMAT_INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
