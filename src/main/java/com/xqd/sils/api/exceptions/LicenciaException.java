package com.xqd.sils.api.exceptions;

/**
 * @author Miguel F.
 */
public class LicenciaException extends RuntimeException {
    private LicenciaException(String message) {
        super(message);
    }

    public static LicenciaException of(String value) {
        return new LicenciaException(value);
    }
}
