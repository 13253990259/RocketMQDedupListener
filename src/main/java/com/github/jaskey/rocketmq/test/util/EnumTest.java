package com.github.jaskey.rocketmq.test.util;

import com.github.jaskey.rocketmq.test.util.enums.PersonEnum;
import com.github.jaskey.rocketmq.test.util.enums.VerdorEnum;

import java.util.List;

public class EnumTest {

    public static void main(String[] args) {
        VerdorEnum yidong = EnumUtil.getEnumByValue("yidong", VerdorEnum.class);
        System.out.println(yidong);
        System.out.println(yidong.value());
        System.out.println(yidong.desc());
        System.out.println(yidong.name());
        System.out.println("----------------------------------------");
        PersonEnum p = EnumUtil.getEnumByValue(1, PersonEnum.class);
        System.out.println(p);
        System.out.println(p.value());
        System.out.println(p.desc());
        System.out.println(p.name());
        System.out.println("----------------------------------------");



        System.out.println("----------------------------------------");
        List<String> codeList = EnumUtil.getValueList(VerdorEnum.class);
        System.out.println(codeList);
        System.out.println("----------------------------------------");
        List<Integer> personList = EnumUtil.getValueList(PersonEnum.class);
        System.out.println(personList);

        System.out.println("----------------------------------------");
        String dianxin = EnumUtil.getDescByValue("dianxin", VerdorEnum.class);
        System.out.println(dianxin);

        String descriptionByCode = EnumUtil.getDescByValue(3, PersonEnum.class);
        System.out.println(descriptionByCode);

        String slag = EnumUtil.getDescByValue(4, PersonEnum.class);
        System.out.println(slag);


    }
}
