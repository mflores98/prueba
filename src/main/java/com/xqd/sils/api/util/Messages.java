package com.xqd.sils.api.util;

public enum Messages {
//    RESPONSE_LOGIN_INVALID("El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros. Por favor, revisa e inténtalo de nuevo."),
    RESPONSE_AUTO_EXISTE("El auto ya existe"),
    RESPONSE_TIPO_NO_EXISTE("El tipo no existe"),
    DATOS_INCORRECTOS("Datos incorrectos");
//    NO_TIENE_LICENCIA("No tiene licencia"),
//    NO_CONTIENE_DISPOSITIVO("No tienen dispositivo"),
//    LICENCIA_YA_EXISTE("El UUID de licencia ya existe");
    private final String cause;

    Messages(String accion) {
        this.cause = accion;
    }

    public String getCause() {
        return cause;
    }
}
