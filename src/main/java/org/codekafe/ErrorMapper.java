package org.codekafe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(ErrorMapper.class);
    @Inject
    ObjectMapper objectMapper;
    @Override
    public Response toResponse(Exception e) {
        LOGGER.error("Failed to handle request", e);

        int code = 500;
        if (e instanceof WebApplicationException) {
            code = ((WebApplicationException) e).getResponse().getStatus();
        }

        ObjectNode exceptionJson = objectMapper.createObjectNode();
        exceptionJson.put("exceptionType", e.getClass().getName());
        exceptionJson.put("code", code);

        if (e.getMessage() != null) {
            exceptionJson.put("error", e.getMessage());
        }

        return Response.status(code)
                .entity(exceptionJson)
                .build();
    }
}
