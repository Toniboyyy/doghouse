package org.helvecia.mapper;

import java.util.List;

import org.helvecia.dto.PaginationDto;
import org.helvecia.entities.PageEntity;
import org.helvecia.entities.enumerations.Sorting;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PaginationMapper {

    public <T, K> PaginationDto<T> mapToDto(PageEntity<K> entity, IMapper<T,K> mapper, int pageIndex, int pageSize) {
        var dto = new PaginationDto<T>();

        dto.setEntries(entity.getEntries().stream().map(en -> mapper.mapToDto(en)).toList());
        dto.setTotalEntries(entity.getTotalAmount());
        dto.setPageSize(pageSize);
        dto.setPageIndex(pageIndex);

        return dto;
    }

    public Sort getSortDirection(Sorting sorting, String column){
        return sorting.equals(Sorting.ASC) ? Sort.ascending(column) : Sort.descending(column);
    }

}
