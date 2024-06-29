package com.ieening.shortlink.admin.common.convention.exception;

import java.util.Optional;

import org.springframework.util.StringUtils;

import com.ieening.shortlink.admin.common.convention.errorcode.IErrorCode;

import lombok.Getter;

/**
 * 异常抽象类
 */
@Getter
public abstract class AbstractException extends RuntimeException{
    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
