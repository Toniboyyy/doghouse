package org.helvecia.services;

import java.util.List;

import org.helvecia.entities.DogEntity;

public interface IDogService {

    DogEntity saveEntity(DogEntity entity);
    
    DogEntity updateEntity(DogEntity entity);

    DogEntity deleteEntity(Long id);

    DogEntity getEntityById(Long id);

    List<DogEntity> getPaginationEntity(int padeIndex, int entries);

    List<DogEntity> getAllEntities();
}
