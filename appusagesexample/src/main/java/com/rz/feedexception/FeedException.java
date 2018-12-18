package com.rz.feedexception;

public class FeedException extends Exception {
    private String errorMessage = null;
    private int errorCode;

    public FeedException() {
        super();
    }

    public FeedException(String argErrorMessage) {
        super(argErrorMessage);
        errorMessage = argErrorMessage;
    }

    public FeedException(int argErrorCode) {
        errorCode = argErrorCode;
    }

    public FeedException(Throwable argCause) {
        super(argCause);
    }

    public FeedException(String argErrorMessage, Throwable argCause) {
        super(argErrorMessage, argCause);
        errorMessage = argErrorMessage;
    }

    public FeedException(String argErrorMessage, int argErrorCode) {
        super(argErrorMessage);
        errorCode = argErrorCode;
    }

    public FeedException(Throwable argCause, int argErrorCode) {
        super(argCause);
        errorCode = argErrorCode;
    }

    public FeedException(String argErrorMessage, Throwable argCause, int argErrorCode) {
        super(argErrorMessage, argCause);
        errorCode = argErrorCode;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    public int getCode() {
        return errorCode;
    }
}
//https://stackify.com/java-custom-exceptions/