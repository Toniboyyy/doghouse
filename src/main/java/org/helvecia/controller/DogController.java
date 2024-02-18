package org.helvecia.controller;
import java.util.List;

import org.helvecia.dto.DogDto;
import org.helvecia.dto.PaginationDto;
import org.helvecia.entities.DogEntity;
import org.helvecia.entities.enumerations.Sorting;
import org.helvecia.exceptions.DogOverflowException;
import org.helvecia.exceptions.EntityNotFoundException;
import org.helvecia.mapper.DogMapper;
import org.helvecia.mapper.IMapper;
import org.helvecia.mapper.PaginationMapper;
import org.helvecia.services.IDogService;
import org.helvecia.utils.ValidationGroups.Create;
import org.helvecia.utils.ValidationGroups.Update;
import org.jboss.resteasy.reactive.ResponseStatus;

import io.quarkus.panache.common.Page;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
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

    private IDogService dogService;
    private IMapper<DogDto, DogEntity> mapper;
    private PaginationMapper paginatMapper;


    public DogController(IDogService dogService, DogMapper dogMapper, PaginationMapper paginatMapper) {
        this.dogService = dogService;
        this.mapper = dogMapper;
        this.paginatMapper = paginatMapper;
    }

    @POST
    @ResponseStatus(201)
    public DogDto saveEntity(@Valid @ConvertGroup(to = Create.class) DogDto dogDto) throws DogOverflowException {
        var dog = this.dogService.saveEntity(mapper.mapToEntity(dogDto));
        return mapper.mapToDto(dog);
    }

    @PUT
    public DogDto updateEntity(@Valid @ConvertGroup(to = Update.class)DogDto dogDto) throws EntityNotFoundException {
        var dog = this.dogService.updateEntity(mapper.mapToEntity(dogDto));
        return mapper.mapToDto(dog);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEntity(@PathParam("id")Long id) throws EntityNotFoundException {
        this.dogService.deleteEntity(id);
    }

    @GET
    @Path("/{id}")
    public DogDto getEntityById(@PathParam("id")Long id) throws EntityNotFoundException {
        return mapper.mapToDto(dogService.getEntityById(id));
    }

    @GET
    @Path("/page")
    public PaginationDto<DogDto> getPagination(@QueryParam("index") int pageIndex, @QueryParam("size") int pageSize, @QueryParam("sort") Sorting sorting) {
        var page = Page.of(pageIndex, pageSize);
        var sort = paginatMapper.getSortDirection(sorting, "date");
        var pagination = dogService.getPaginationEntity(page, sort);

       return paginatMapper.mapToDto(pagination, mapper, pageIndex, pageSize);
    }

    @GET
    @Path("/list")
    public List<DogDto> getAll(@QueryParam("sort") Sorting sorting) {
        var response = dogService.getAllEntities(paginatMapper.getSortDirection(sorting, "date"));
        return response.stream().map(mapper::mapToDto).toList();
    }
}