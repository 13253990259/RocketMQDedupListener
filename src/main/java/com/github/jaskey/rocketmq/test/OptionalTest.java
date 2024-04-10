package com.github.jaskey.rocketmq.test;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Object o = "1234567";
        Optional.ofNullable(o).ifPresent(object -> {
            Long l = Long.valueOf(object.toString());
            System.out.println(l);

        });
    }
}
