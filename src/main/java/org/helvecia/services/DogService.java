package org.helvecia.services;

import java.util.List;

import org.helvecia.entities.DogEntity;
import org.helvecia.exceptions.DogOverflowException;
import org.helvecia.persistance.IDogDAO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DogService implements IDogService {

    private IDogDAO dogDAO;

    public DogService(IDogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }

    @Override
    @Transactional
    public DogEntity saveEntity(DogEntity entity) throws DogOverflowException {
        if(dogDAO.countEntities() < 10){
            return dogDAO.saveEntity(entity);
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
    
}
