package com.github.jaskey.rocketmq.test.util;

import com.github.jaskey.rocketmq.test.util.converter.PersonConverter;
import com.github.jaskey.rocketmq.test.util.po.CatPO;
import com.github.jaskey.rocketmq.test.util.po.PersonPO;
import com.github.jaskey.rocketmq.test.util.vo.CatVO;
import com.github.jaskey.rocketmq.test.util.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static void main(String[] args) {
        List<PersonPO> poList = new ArrayList<>();
        PersonPO po1 = new PersonPO();
        po1.setId(1);
        po1.setName("haha");
        po1.setAge(18);

        PersonPO po2 = new PersonPO();
        po2.setId(2);
        po2.setName("好贵");
        po2.setAge(20);

        poList.add(po1);
        poList.add(po2);

        List<PersonVO> personVOList = GenericlUtil.convertList(poList, PersonConverter::converterPersonPO);
        System.out.println(personVOList);

        List<CatPO> catPOS = new ArrayList<>();
        CatPO catPO = new CatPO();
        catPO.setAge(5);
        catPO.setName("画画");

        CatPO catPO1 = new CatPO();
        catPO1.setAge(10);
        catPO1.setName("啊哈");

        catPOS.add(catPO1);
        catPOS.add(catPO);

        List<CatVO> catVOS = GenericlUtil.convertList(catPOS, PersonConverter::converterCatVo);
        System.out.println(catVOS);


    }
}
