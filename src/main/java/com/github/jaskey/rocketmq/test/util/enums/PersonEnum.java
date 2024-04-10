package com.github.jaskey.rocketmq.test.util.enums;

public enum PersonEnum implements AbstractEnum<Integer> {

    STUDNET(1, "学生"),

    WORKER(2, "工人"),

    TEACHER(3, "老师")


    ;

    private Integer value;
    private String desc;

    PersonEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public String desc() {
        return desc;
    }
}
