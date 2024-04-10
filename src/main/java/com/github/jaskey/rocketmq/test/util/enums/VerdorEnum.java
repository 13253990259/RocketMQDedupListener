package com.github.jaskey.rocketmq.test.util.enums;

public enum VerdorEnum implements AbstractEnum<String> {

    CHINA_YIDONG("yidong", "移动"),

    CHINA_LIANTONG("Unicom", "联通"),

    CHINA_DIANXIN("dianxin", "电信")


    ;

    private String value;
    private String desc;

    VerdorEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String desc() {
        return desc;
    }
}
