package com.chabao.common.config.exception;

import com.chabao.result.ResultCodeEnum;
import lombok.Data;

@Data
public class ChaBaoException extends RuntimeException {

    private Integer code;//状态码
    private String msg;//描述信息

    public ChaBaoException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public ChaBaoException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "自定义异常接收：Exception{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
