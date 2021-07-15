package com.xqd.sils.api.exceptions;

import org.springframework.http.HttpStatus;

import java.util.concurrent.CompletionException;

public enum SupportedException {


    UNAUTHORIZED(LicenciaException.class, HttpStatus.SEE_OTHER),
    NOT_CONTENT(DispositivoException.class, HttpStatus.SEE_OTHER),
    EXCEPTION_CONCURRENT(CompletionException.class, HttpStatus.SEE_OTHER);
//    CONFLICT(CompraException.class, HttpStatus.CONFLICT);
//    STUDENT_UNDER_AGE(UsuarioException.class, HttpStatus.INTERNAL_SERVER_ERROR),
//    ARTICULO_NOT_SAVE(ArticuloException.class, HttpStatus.NOT_ACCEPTABLE);

    // By creating Class<? extends Throwable> enforces type on SupportedExceptions
    // Uncomment the following code line to see how the code won't compile, since object is not throwable
    //INVALID_SUPPORTED_EXCEPTION(Object.class, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);


    /**
     * in Spring, it depends on the application's use case how exceptions should be handle to return a response
     * which is why as developers we are responsible of this.
     * This approach to exception handling, forces all supported exceptions to share similar properties, even if
     * this is a very simple example, we can defined supported exceptions to provide an {@link HttpStatus}, thus
     * enabling future modifications to forcefully provide this important detail.
     */
    private final Class<? extends Throwable> exceptionClass;
    private final HttpStatus status;

    /**
     * Notice how this constructor uses generics to accept any object that can be thrown as an exception.
     * This is essential so that new SupportedExceptions are in fact {@link Throwable} objects
     * And that can be catched by the exception handler.
     * For more details see {@link //com.configuration.RestExceptionInterceptor}
     *
     * @param exception exception
     * @param status status
     */
    SupportedException(Class<? extends Throwable> exception, HttpStatus status) {
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class<? extends Throwable> getExceptionClass() {
        return this.exceptionClass;
    }

    public HttpStatus getStatus() {
        return this.status;
    }


}
