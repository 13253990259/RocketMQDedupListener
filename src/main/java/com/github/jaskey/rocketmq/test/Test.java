package com.github.jaskey.rocketmq.test;

public class Test {
    public static void main(String[] args) {
        String inputString = "+80123456";
        processString(inputString);
    }

    public static void processString(String inputString) {
        // 检查是否是手机号码
        if (inputString.matches("[+]?\\d{8,14}")) {
            processPhoneNumber(inputString);
        }
        // 检查是否是邮箱
        else if (inputString.matches("[\\w\\.-]+@[\\w\\.-]+\\.\\w+")) {
            processEmail(inputString);
        }
    }

    public static void processPhoneNumber(String phoneNumber) {
        // 手机号码处理规则
        System.out.println("处理手机号码: " + phoneNumber);
        // 添加你的处理逻辑
    }

    public static void processEmail(String email) {
        // 邮箱处理规则
        System.out.println("处理邮箱: " + email);
        // 添加你的处理逻辑
    }
}
