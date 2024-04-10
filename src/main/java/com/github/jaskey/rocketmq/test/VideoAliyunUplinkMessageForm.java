package com.github.jaskey.rocketmq.test;

public class VideoAliyunUplinkMessageForm extends VideoUplinkMessageForm {

    /**
     * 供应商签名
     */
    private String signName;

    /**
     * 视频短信类型
     */
    private String smsType;

    /**
     * 扩展号，阿里云自动生成
     */
    private String destCode;

    public VideoAliyunUplinkMessageForm(String mobile, String serviceCode, Long receiveTime, String content) {
        super(null, mobile, serviceCode, receiveTime, content);
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getDestCode() {
        return destCode;
    }

    public void setDestCode(String destCode) {
        this.destCode = destCode;
    }

    @Override
    public String toString() {
        return "VideoAliyunUplinkMessageForm{" +
                "signName='" + signName + '\'' +
                ", smsType='" + smsType + '\'' +
                ", destCode='" + destCode + '\'' +
                '}';
    }
}
