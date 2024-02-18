package org.helvecia.services;

import java.util.List;

import org.helvecia.entities.DogEntity;
import org.helvecia.exceptions.DogOverflowException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DogService implements IDogService {

    @Override
    @Transactional
    public DogEntity saveEntity(DogEntity entity) throws DogOverflowException {
        if(DogEntity.count() < 10){
            DogEntity.persist(entity);
            return entity;
        }
        throw new DogOverflowException();
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
                throw new UnsupportedOperationException("Unimplemented method 'deleteEntity'");
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
    
}
