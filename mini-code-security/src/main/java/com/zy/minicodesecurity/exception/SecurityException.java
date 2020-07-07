package com.zy.minicodesecurity.exception;

import com.zy.minicodesecurity.common.BaseException;
import com.zy.minicodesecurity.common.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * date:  2020-07-07 17:46
 *
 * @author zhengyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SecurityException extends BaseException {

    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
