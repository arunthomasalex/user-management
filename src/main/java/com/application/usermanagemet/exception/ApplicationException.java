package com.application.usermanagemet.exception;

public class ApplicationException {
    public static class NoData extends BaseException {
        private static final long serialVersionUID = 1L;
        public NoData(String message) {
            super(message);
        }
    }

    public static class CommonError extends BaseException {
        private static final long serialVersionUID = 1L;
        public CommonError(String message) {
            super(message);
        }
    }
}