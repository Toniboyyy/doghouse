package org.helvecia.mapper;

import java.util.List;

import org.helvecia.dto.DogDto;
import org.helvecia.dto.PaginationDto;
import org.helvecia.entities.DogEntity;

public class DogMapper implements IMapper<DogDto, DogEntity>{

    @Override
    public DogEntity mapToEntity(DogDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }

    @Override
    public DogDto mapToDto(DogEntity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToDto'");
    }

    @Override
    public PaginationDto<DogDto> mapToPagination(List<DogDto> list, int pageIndex, int pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToPagination'");
    }

}
