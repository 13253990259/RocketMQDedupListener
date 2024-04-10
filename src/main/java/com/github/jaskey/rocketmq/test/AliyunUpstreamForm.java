package com.github.jaskey.rocketmq.test;


public class AliyunUpstreamForm {

    /**
     * 扩展号
     */
    private String destCode;
    /**
     * 发送时间
     */
    private String sendTime;
    /**
     * 供应商签名
     */
    private String signName;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 短信类型，视频短信 DIGITAL
     */
    private String smstype;
    /**
     * 短信内容
     */
    private String content;

    public String getDestCode() {
        return destCode;
    }

    public void setDestCode(String destCode) {
        this.destCode = destCode;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSmstype() {
        return smstype;
    }

    public void setSmstype(String smstype) {
        this.smstype = smstype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AliyunUpstreamFrom{" +
                "destCode='" + destCode + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", signName='" + signName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", smstype='" + smstype + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
