package com.github.jaskey.rocketmq.test.common;

import com.github.jaskey.rocketmq.test.VideoUplinkMessageForm;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UplinkHelper {

    public static <T, R extends VideoUplinkMessageForm> Function<T, R> buildMessageFrom(UplinkMessageConverter<T, R> converter) {
        return (T uplinkMessage) -> {
            R videoUplinkMessageForm = converter.convertFrom(uplinkMessage);
            return videoUplinkMessageForm;
        };
    }

}
