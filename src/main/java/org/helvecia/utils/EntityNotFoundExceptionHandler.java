package org.helvecia.utils;

import org.helvecia.exceptions.EntityNotFoundException;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundExceptionHandler implements ExceptionMapper<EntityNotFoundException>{

    @Override
    public Response toResponse(EntityNotFoundException exception) {
        Log.info(exception);
        return Response.status(Status.NOT_FOUND).entity(Status.NOT_FOUND.name()).build();
    }
    
}
