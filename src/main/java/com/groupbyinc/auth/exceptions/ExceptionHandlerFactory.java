package com.groupbyinc.auth.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.bind.exceptions.UnsatisfiedArgumentException;
import io.micronaut.core.convert.exceptions.ConversionErrorException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.exceptions.ContentLengthExceededException;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.http.server.exceptions.*;
import io.micronaut.validation.exceptions.ConstraintExceptionHandler;
import io.micronaut.web.router.exceptions.DuplicateRouteException;
import io.micronaut.web.router.exceptions.UnsatisfiedRouteException;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import java.net.URISyntaxException;

@Factory
@RequiredArgsConstructor
public class ExceptionHandlerFactory {

    private final GlobalExceptionHandler globalApiExceptionHandler;

    @Singleton
    @Replaces(ConstraintExceptionHandler.class)
    public ExceptionHandler<ConstraintViolationException, HttpResponse<?>> constraintExceptionHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(ContentLengthExceededHandler.class)
    public ExceptionHandler<ContentLengthExceededException, HttpResponse<?>> contentLengthExceededHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(ConversionErrorHandler.class)
    public ExceptionHandler<ConversionErrorException, HttpResponse<?>> conversionErrorHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(DuplicateRouteHandler.class)
    public ExceptionHandler<DuplicateRouteException, HttpResponse<?>> duplicateRouteHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(HttpStatusHandler.class)
    public ExceptionHandler<HttpStatusException, HttpResponse<?>> httpStatusHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(JsonExceptionHandler.class)
    public ExceptionHandler<JsonProcessingException, HttpResponse<?>> jsonExceptionHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(URISyntaxHandler.class)
    public ExceptionHandler<URISyntaxException, HttpResponse<?>> uriSyntaxHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(UnsatisfiedArgumentHandler.class)
    public ExceptionHandler<UnsatisfiedArgumentException, HttpResponse<?>> unsatisfiedArgumentHandler() {
        return globalApiExceptionHandler::handle;
    }

    @Singleton
    @Replaces(UnsatisfiedRouteHandler.class)
    public ExceptionHandler<UnsatisfiedRouteException, HttpResponse<?>> unsatisfiedRouteHandler() {
        return globalApiExceptionHandler::handle;
    }

}