package org.helvecia.utils.exceptionHandler;

import org.helvecia.exceptions.DogOverflowException;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
@Provider
public class DogOverflowExceptionHandler implements ExceptionMapper<DogOverflowException>{

    @Override
    public Response toResponse(DogOverflowException exception) {
        Log.info(exception);
        return Response.status(Status.BAD_REQUEST).entity(Status.BAD_REQUEST.name()).build();
    }
    
}
