package com.github.jaskey.rocketmq.test.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class BaseResponse<R> {
    /**
     * 返回code码，0 成功 | 其他失败
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String msg;

    private R data;


    public boolean success() {
        return Objects.equals(0, code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }
}
