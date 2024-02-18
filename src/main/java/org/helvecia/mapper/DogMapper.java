package org.helvecia.mapper;

import java.util.List;

import org.helvecia.dto.DogDto;
import org.helvecia.dto.PaginationDto;
import org.helvecia.entities.DogEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogMapper implements IMapper<DogDto, DogEntity>{

    @Override
    public DogEntity mapToEntity(DogDto dto) {
        var dog = new DogEntity();

        dog.id = dto.getId();
        dog.setName(dto.getName());
        dog.setGender(dto.getGender());
        dog.setDate(dto.getDate());

        return dog;
    }

    @Override
    public DogDto mapToDto(DogEntity entity) {
        var dto = new DogDto();

        dto.setId(entity.id);
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setDate(entity.getDate());
        
        return dto;
    }

    @Override
    public PaginationDto<DogDto> mapToPagination(List<DogDto> list, int pageIndex, int pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToPagination'");
    }

}
