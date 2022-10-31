package com.groupbyinc.auth.exceptions;
import io.micronaut.http.HttpRequest;
import lombok.Value;
import java.util.Collections;
import java.util.List;

@Value
public class ErrorResponse {

    String trackingId;
    String method;
    String path;
    String message;
    List<String> warnings;

    public ErrorResponse(String trackingId, HttpRequest<?> request, String message) {
        this(trackingId, request, message, Collections.EMPTY_LIST);
    }

    public ErrorResponse(String trackingId, HttpRequest<?> request, String message, List<String> warnings) {
        this.trackingId = trackingId;
        this.method = request.getMethod().name();
        this.path = request.getPath();
        this.message = message;
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
            "trackingId='" + trackingId + '\'' +
            ", method='" + method + '\'' +
            ", path='" + path + '\'' +
            ", message='" + message + '\'' +
            ", warnings='" + warnings + '\'' +
            '}';
    }

}