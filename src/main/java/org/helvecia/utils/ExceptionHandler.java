package org.helvecia.utils;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(Status.INTERNAL_SERVER_ERROR.name()).build();
    }

    
}