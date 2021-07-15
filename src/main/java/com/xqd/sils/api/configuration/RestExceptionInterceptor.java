package com.xqd.sils.api.configuration;

import com.google.common.collect.ImmutableMap;
import com.xqd.sils.api.exceptions.SupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionInterceptor {

    @ExceptionHandler
    public ResponseEntity<Map<Object, Object>> processSupportedExceptions(Throwable throwable) {
        Optional<ResponseEntity<Map<Object, Object>>> supportedException = Arrays.stream(SupportedException.values())
                .filter(supportedEx -> hasSameClass(supportedEx, throwable))
                .map(supportedEx -> createResponseEntityFromException(supportedEx, throwable)).findFirst();

        // return the matching supportedException if present, if not, respond with INTERNAL_SERVER_ERROR
        return supportedException.orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private boolean hasSameClass(SupportedException exception, Throwable throwable) {
        return throwable.getClass().equals(exception.getExceptionClass());
    }

    private ResponseEntity<Map<Object, Object>> createResponseEntityFromException(SupportedException exception, Throwable throwable) {
        Objects.requireNonNull(exception);
        return new ResponseEntity<>(ImmutableMap.builder()
                .put("status", exception.getStatus().value())
                .put("error", exception.getStatus().getReasonPhrase())
                .put("message", throwable.getCause() == null ? throwable.getMessage() : throwable.getCause().getMessage())
                .build(),
                exception.getStatus());
    }
}
