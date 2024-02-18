package org.helvecia.mapper;

public interface IMapper<T,K> {
    
    K mapToEntity(T dto);

    T mapToDto(K entity);

}
