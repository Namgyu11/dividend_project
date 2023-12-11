package com.dayone.dividend_project.exception.impl;

import com.dayone.dividend_project.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NoCompanyException extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMassage() {
        return "존재하지 않는 회사명 입니다.";
    }
}
