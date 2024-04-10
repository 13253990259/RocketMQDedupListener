package com.github.jaskey.rocketmq.test.util;

import com.github.jaskey.rocketmq.test.util.enums.AbstractEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnumUtil {

    private EnumUtil() {
    }

    public static <T> String getDescByValue(T value, Class<? extends AbstractEnum<T>> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> Objects.equals(e.value(), value))
                .findFirst()
                .map(AbstractEnum::desc)
                .orElse("");
    }

    public static <T, E extends AbstractEnum<T>> E getEnumByValue(T value, Class<E> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> Objects.equals(e.value(), value))
                .findFirst()
                .orElse(null);
    }

    public static <E> List<E> getValueList(Class<? extends AbstractEnum<E>> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(AbstractEnum::value)
                .collect(Collectors.toList());
    }
}
