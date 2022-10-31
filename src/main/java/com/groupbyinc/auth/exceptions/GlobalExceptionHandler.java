package com.groupbyinc.auth.exceptions;

import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.logging.LogLevel;
import io.micronaut.transaction.support.ExceptionUtil;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.internal.util.ExceptionUtils;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Primary
@Produces
@Singleton
public class GlobalExceptionHandler implements ExceptionHandler<Throwable, HttpResponse<?>> {

    /**
     * Simple random for generating tracking IDs as opposed to true UUID, so that
     * we don't needlessly rely on an entropy source.
     */
    private static final Random TRACKING_ID_RANDOMIZER = new Random();

    /**
     * Handles an internal error that is propagated all the way up to the API layer
     * by transforming it to a sane HTTP response.
     *
     * @param request The HTTP request that caused the issue.
     * @param t       The internal error that is internally thrown but not caught.
     *
     * @return An HTTP response with the appropriate status and body {@link ErrorResponse}.
     */
    @Override
    public HttpResponse<ErrorResponse> handle(HttpRequest request, Throwable t) {
        return badRequest(request, t);
    }

    public static MutableHttpResponse<ErrorResponse> badRequest(HttpRequest<?> request, Throwable t) {
        var response = new ErrorResponse(getId(), request, t.getMessage());
        log.error("AUTHENTICATION API ERROR: {}", response, ExceptionUtils.getRootCause(t));
        return HttpResponse.badRequest(response);
    }

    private static String getId() {
        return new UUID(
                TRACKING_ID_RANDOMIZER.nextLong(),
                TRACKING_ID_RANDOMIZER.nextLong()
        ).toString();
    }
}
