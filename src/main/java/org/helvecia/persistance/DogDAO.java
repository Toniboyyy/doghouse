package org.helvecia.persistance;

import java.util.List;

import org.helvecia.entities.DogEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogDAO implements IDogDAO{
    
    public DogEntity saveEntity(DogEntity entity) {
        entity.persist();
        return entity;
    }

    @Override
    public DogEntity updateEntity(DogEntity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

    @Override
    public DogEntity deleteEntity(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEntity'");
    }

    @Override
    public DogEntity getEntityById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntityById'");
    }

    @Override
    public List<DogEntity> getPaginationEntity(int padeIndex, int entries) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaginationEntity'");
    }

    @Override
    public List<DogEntity> getAllEntities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEntities'");
    }

    @Override
    public Long countEntities() {
        return DogEntity.count();
    }
    
}
