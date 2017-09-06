package org.zalando.problem.spring.web.advice;

import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import java.util.Objects;

/**
 * An implementation of {@link javax.ws.rs.core.Response.StatusType} to map {@link HttpStatus}.
 */
public class HttpStatusAdapter implements Response.StatusType {

    private final HttpStatus status;

    public HttpStatusAdapter(final HttpStatus status) {
        this.status = status;
    }

    @Override
    public int getStatusCode() {
        return status.value();
    }

    @Override
    public Family getFamily() {
        return Family.familyOf(status.value());
    }

    @Override
    public String getReasonPhrase() {
        return status.getReasonPhrase();
    }

    @Override
    public boolean equals(final Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof HttpStatusAdapter) {
            final HttpStatusAdapter other = (HttpStatusAdapter) that;
            return Objects.equals(status, other.status);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status);
    }

}
