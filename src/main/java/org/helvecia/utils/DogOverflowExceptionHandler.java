package org.helvecia.utils;

import org.helvecia.exceptions.DogOverflowException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
@Provider
public class DogOverflowExceptionHandler implements ExceptionMapper<DogOverflowException>{

    @Override
    public Response toResponse(DogOverflowException exception) {
        return Response.status(Status.BAD_REQUEST).entity(Status.BAD_REQUEST.name()).build();
    }
    
}
