package com.dayone.dividend_project.exception;

public abstract class AbstractException extends RuntimeException {
    
    abstract public int getStatusCode();
    abstract public String getMassage();
}
