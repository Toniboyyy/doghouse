package org.helvecia.services;

import java.util.List;

import org.helvecia.entities.DogEntity;
import org.helvecia.entities.PageEntity;
import org.helvecia.exceptions.DogOverflowException;
import org.helvecia.exceptions.EntityNotFoundException;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface IDogService {

    DogEntity saveEntity(DogEntity entity) throws DogOverflowException;
    
    DogEntity updateEntity(DogEntity entity) throws EntityNotFoundException;

    void deleteEntity(Long id) throws EntityNotFoundException;

    DogEntity getEntityById(Long id) throws EntityNotFoundException;

    public PageEntity<DogEntity> getPaginationEntity(Page page, Sort sort);

    List<DogEntity> getAllEntities(Sort sort);
}
