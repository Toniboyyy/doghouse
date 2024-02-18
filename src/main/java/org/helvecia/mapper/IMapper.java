package org.helvecia.mapper;

import java.util.List;

import org.helvecia.dto.PaginationDto;

public interface IMapper<T,K> {
    
    K mapToEntity(T dto);

    T mapToDto(K entity);

    PaginationDto<T> mapToPagination(List<T> list, int pageIndex, int pageSize);

}
