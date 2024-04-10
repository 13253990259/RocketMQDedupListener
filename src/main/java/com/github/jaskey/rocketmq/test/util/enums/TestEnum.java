package com.github.jaskey.rocketmq.test.util.enums;

public enum TestEnum  /*implements AbstractEnum*/{

    STUDNET(1, "学生"),

    WORKER(2, "工人"),

    TEACHER(3, "老师")

    ;

    private Integer value;
    private String desc;

    TestEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /*@Override
    public Object value() {
        return value;
    }

    @Override
    public String desc() {
        return desc;
    }*/
}
