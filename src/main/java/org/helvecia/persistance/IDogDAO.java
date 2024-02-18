package org.helvecia.persistance;

import java.util.List;

import org.helvecia.entities.DogEntity;

public interface IDogDAO {
    
    DogEntity saveEntity(DogEntity entity);
    
    DogEntity updateEntity(DogEntity entity);

    DogEntity deleteEntity(Long id);

    DogEntity getEntityById(Long id);

    List<DogEntity> getPaginationEntity(int padeIndex, int entries);

    List<DogEntity> getAllEntities();

    Long countEntities();
}
