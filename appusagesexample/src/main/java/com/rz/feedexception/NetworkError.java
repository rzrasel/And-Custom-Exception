package com.rz.feedexception;

public class NetworkError extends FeedException {
    private String errorMessage = null;

    public NetworkError() {
        super();
    }

    public NetworkError(String argErrorMessage) {
        super(argErrorMessage);
        errorMessage = argErrorMessage;
    }

    public NetworkError(Throwable argCause) {
        super(argCause);
    }

    public NetworkError(String argErrorMessage, Throwable argCause) {
        super(argErrorMessage, argCause);
        errorMessage = argErrorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
