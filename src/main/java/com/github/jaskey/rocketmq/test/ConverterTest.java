package com.github.jaskey.rocketmq.test;

import com.github.jaskey.rocketmq.test.common.UplinkHelper;

import java.util.*;

public class ConverterTest {
    public static void main(String[] args) {
        /*List<ShanghaiUnicomUpstreamFrom> list = new ArrayList<>();
        ShanghaiUnicomUpstreamFrom from = new ShanghaiUnicomUpstreamFrom();
        from.setTransId(1L);
        from.setPhone("1234556778");
        from.setIspCode("3434");
        from.setNumber("rrr");
        from.setMessage("退订");
        from.setPushTime("2024-03-06 14:30:00");
        list.add(from);

        for (ShanghaiUnicomUpstreamFrom shanghaiUnicomUpstreamFrom : list) {
            VideoUplinkMessageForm videoUplinkMessageForm = UplinkHelper.buildMessageFrom(new shanghai.ShanghaiUnicomUplinkMessageConvert())
                    .apply(shanghaiUnicomUpstreamFrom);
            System.out.println(videoUplinkMessageForm.toString());

        }

        List<AliyunUpstreamForm> list2 = new ArrayList<>();
        AliyunUpstreamForm form2 = new AliyunUpstreamForm();
        form2.setSignName("[两三个]");
        form2.setContent("退订十来个");
        form2.setDestCode("23232");
        form2.setSmstype("DESAGE");
        form2.setPhoneNumber("13121311323");
        form2.setSendTime("2024-04-03 12:00:00");
        list2.add(form2);
        for (AliyunUpstreamForm form : list2) {
            VideoAliyunUplinkMessageForm videoAliyunUplinkMessageForm = UplinkHelper.buildMessageFrom(new shanghai.AliyunUplinkMessageConvert())
                    .apply(form);
            System.out.println(videoAliyunUplinkMessageForm.toString());
        }*/

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 3);
        long time = calendar.getTime().getTime();
        System.out.println(time);
        


    }
}
