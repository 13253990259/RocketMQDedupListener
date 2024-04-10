package com.github.jaskey.rocketmq.test.util;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericlUtil {

    public static <T, R> List<R> convertList(List<T> list, Function<T, R> function) {
        return (list == null || list.isEmpty()) ? Collections.emptyList() : list.stream().map(function).collect(Collectors.toList());
    }
}
