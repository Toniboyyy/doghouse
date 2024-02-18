package org.helvecia.utils;

import java.util.Map;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException exception) {        
        Map<String, String> errorMessages = exception.getConstraintViolations().stream()
        .collect(
            Collectors.toMap(
                constraintViolation -> constraintViolation.getPropertyPath().toString(),
                constraintViolation -> constraintViolation.getMessage()
        ));
        return Response.status(Status.BAD_REQUEST).entity(errorMessages).build();
    }

    
}
