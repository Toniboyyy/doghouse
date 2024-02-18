package org.helvecia.controller;
import java.util.List;

import org.helvecia.dto.DogDto;
import org.helvecia.dto.PaginationDto;
import org.helvecia.entities.enumerations.Sorting;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/dog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DogController {

    @POST
    public DogDto saveEntity(DogDto dogDto) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'saveEntity'");
    }

    @PUT
    public DogDto updateEntity(DogDto dogDto) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

    @DELETE
    @Path("/{id:\\d+}")
    public void deleteEntity(@PathParam("id")Long id) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

    @GET
    @Path("/{id:\\d+}")
    public DogDto getEntityById(@PathParam("id")Long id) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getEntityById'");
    }

    @GET
    @Path("/page")
    public PaginationDto<DogDto> getPagination(@QueryParam("index") int pageIndex, @QueryParam("size") int pageSize, @QueryParam("sort") Sorting sorting) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getEntityById'");
    }

    @GET
    @Path("/list")
    public List<DogDto> getAll(@QueryParam("sort") Sorting sorting) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getEntityById'");
    }
}