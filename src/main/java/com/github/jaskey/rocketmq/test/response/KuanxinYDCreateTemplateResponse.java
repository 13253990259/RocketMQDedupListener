package com.github.jaskey.rocketmq.test.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class KuanxinYDCreateTemplateResponse {

    /**
     * 供应商模板id
     */
    private String mmsId;

    public String getTemplateId() {
        return mmsId;
    }

}
