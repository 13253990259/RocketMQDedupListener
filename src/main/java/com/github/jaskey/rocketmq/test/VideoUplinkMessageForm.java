package com.github.jaskey.rocketmq.test;

import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

public class VideoUplinkMessageForm {
    private String vendorId;
    private String mobile;
    private String serviceCode;
    private Long receiveTime;
    private String content;

    public VideoUplinkMessageForm(String vendorId, String mobile, String serviceCode, Long receiveTime, String content) {
        this.vendorId = vendorId;
        Assert.hasText(mobile, "mobile cannot be empty");
        this.mobile = mobile;
        Assert.hasText(serviceCode, "service code cannot be empty");
        this.serviceCode = serviceCode;
        this.receiveTime = Optional.ofNullable(receiveTime).orElse(System.currentTimeMillis());
        this.content = content;
    }

    public static void main(String[] args) {
        Object o = 1234567;
        Long userId = 123456L;
        Optional<Object> optionalValue = Optional.ofNullable(o);

        optionalValue.ifPresent(value -> {
            Long oldUserId = Long.valueOf(value.toString());
            if (!Objects.equals(userId, oldUserId)) {
                System.out.println("更新值：" + userId);
            }
        });
        optionalValue.orElseGet(() -> {
            System.out.println("新增值：" + userId);
            return userId;
            
        });
    }

    public VideoUplinkMessageForm(String mobile, String serviceCode, Long receiveTime, String content) {
        this(null, mobile, serviceCode, receiveTime, content);
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Long receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "VideoUplinkMessageForm{" +
                "vendorId='" + vendorId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", receiveTime=" + receiveTime +
                ", content='" + content + '\'' +
                '}';
    }
}
