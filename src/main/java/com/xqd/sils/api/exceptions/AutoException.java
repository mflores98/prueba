package com.xqd.sils.api.exceptions;

/**
 * @author Miguel F.
 */
public class AutoException extends RuntimeException {
    private AutoException(String message) {
        super(message);
    }

    public static AutoException of(String value) {
        return new AutoException(value);
    }
}
