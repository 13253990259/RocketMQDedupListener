package com.github.jaskey.rocketmq;

import java.util.regex.Pattern;

public class TestPhone {

    private static final Pattern PATTERN = Pattern.compile("^(1[3-9][0-9])\\d{8}$");

    private static final Pattern INTER_PATTERN = Pattern.compile("^\\+\\d+$");
    public static void main(String[] args) {
        String phone = "13283888478";
        boolean chinaPhoneOrForeignPhone = isChinaPhoneOrForeignPhone(phone);
        System.out.println(chinaPhoneOrForeignPhone);
    }

    public static boolean isChinaPhoneOrForeignPhone(String source) {
        boolean r = isPhone(source);
        if (r){
            return true;
        }
        else {
            return isForeignNumber(source);
        }
    }

    public static boolean isPhone(String source) {
        if (source == null) {
            return false;
        }
        if(source.startsWith("+86")){
            source = source.substring(3);
        }
        return PATTERN.matcher(source).matches();
    }

    public static Boolean isForeignNumber(String mobile) {
        if (mobile == null) {
            return false;
        }
        // 所有国际号码必须以 + 开头
        // 非 + 开头的号码都认为是国内号码
        // +86 为国内号码
        if(mobile.startsWith("+86") || !mobile.startsWith("+")) {
            return false;
        }
        return INTER_PATTERN.matcher(mobile).matches();
    }
}
