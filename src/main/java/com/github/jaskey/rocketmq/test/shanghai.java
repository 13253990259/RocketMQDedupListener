package com.github.jaskey.rocketmq.test;

import com.github.jaskey.rocketmq.test.common.UplinkMessageConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class shanghai {

    public static class ShanghaiUnicomUplinkMessageConvert implements UplinkMessageConverter<ShanghaiUnicomUpstreamFrom, VideoUplinkMessageForm> {
        @Override
        public VideoUplinkMessageForm convertFrom(ShanghaiUnicomUpstreamFrom uplinkMessage) {
            LocalDateTime parseTime = LocalDateTime.parse(
                    uplinkMessage.getPushTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new VideoUplinkMessageForm(
                    uplinkMessage.getPhone(),
                    uplinkMessage.getNumber(),
                    parseTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
                    uplinkMessage.getMessage()
            );
        }
    }

    public static class AliyunUplinkMessageConvert implements UplinkMessageConverter<AliyunUpstreamForm, VideoAliyunUplinkMessageForm> {
        @Override
        public VideoAliyunUplinkMessageForm convertFrom(AliyunUpstreamForm uplinkMessage) {
            LocalDateTime parseTime = LocalDateTime.parse(
                    uplinkMessage.getSendTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            VideoAliyunUplinkMessageForm form = new VideoAliyunUplinkMessageForm(
                    uplinkMessage.getPhoneNumber(),
                    uplinkMessage.getDestCode(),
                    parseTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
                    uplinkMessage.getContent()
            );
            form.setSignName(uplinkMessage.getSignName());
            form.setDestCode(uplinkMessage.getDestCode());
            form.setSmsType(uplinkMessage.getSmstype());
            return form;
        }
    }
}
