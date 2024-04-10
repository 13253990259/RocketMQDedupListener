package com.github.jaskey.rocketmq.test.common;


import com.github.jaskey.rocketmq.test.VideoUplinkMessageForm;

public interface UplinkMessageConverter<T, R extends VideoUplinkMessageForm> {

    R convertFrom(T uplinkMessage);
}
