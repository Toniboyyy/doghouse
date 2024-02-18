package org.helvecia.utils.exceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

import io.quarkus.logging.Log;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException exception) {        
        Log.info(exception);
        Map<String, String> errorMessages = exception.getConstraintViolations().stream()
        .collect(
            Collectors.toMap(
                constraintViolation -> constraintViolation.getPropertyPath().toString(),
                constraintViolation -> constraintViolation.getMessage()
        ));
        return Response.status(Status.BAD_REQUEST).entity(errorMessages).build();
    }

    
}
