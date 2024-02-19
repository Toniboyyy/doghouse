package org.helvecia.services;

import java.util.List;

import org.helvecia.entities.DogEntity;
import org.helvecia.entities.PageEntity;
import org.helvecia.exceptions.DogOverflowException;
import org.helvecia.exceptions.EntityNotFoundException;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DogService implements IDogService {

    @Override
    @Transactional
    public DogEntity saveEntity(DogEntity entity) throws DogOverflowException {
        if(DogEntity.count() >= 10) {
            throw new DogOverflowException();
        }
        DogEntity.persist(entity);
        return entity;
        
    }

    @Override
    @Transactional
    public DogEntity updateEntity(DogEntity entity) throws EntityNotFoundException {
        var current = getEntityById(entity.id);

        current.setName(entity.getName());
        current.setDate(entity.getDate());
        current.setGender(entity.getGender());
        
        DogEntity.persist(current);
        return current;
    }

    @Override
    @Transactional
    public void deleteEntity(Long id) throws EntityNotFoundException {
        if(!DogEntity.deleteById(id)){
            throw new EntityNotFoundException();
        }

    }

    @Override
    public DogEntity getEntityById(Long id) throws EntityNotFoundException{
        DogEntity dog = DogEntity.findById(id);
        if(dog == null){
            throw new EntityNotFoundException();
        }
        return dog;
    }

    @Override
    public PageEntity<DogEntity> getPaginationEntity(Page page, Sort sort) {
        var pageResult = DogEntity.findAll(sort).page(page);
        return new PageEntity<>(pageResult.list(), pageResult.count(), page.index, page.size);
    }

    @Override
    public List<DogEntity> getAllEntities(Sort sort, String searchTerm) {
        if(searchTerm == null){
            return DogEntity.listAll(sort);
        }
        String jpqlQuery = "SELECT e FROM DogEntity e WHERE LOWER(e.name) LIKE LOWER(:searchString)";
        return DogEntity.find(jpqlQuery, sort, Parameters.with("searchString", "%" + searchTerm.toLowerCase() + "%")).list();
    }
    
}
