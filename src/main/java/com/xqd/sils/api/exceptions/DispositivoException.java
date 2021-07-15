package com.xqd.sils.api.exceptions;

/**
 * @author Miguel F.
 */
public class DispositivoException extends RuntimeException {
    private DispositivoException(String message) {
        super(message);
    }

    public static DispositivoException of(String value) {
        return new DispositivoException(value);
    }
}
