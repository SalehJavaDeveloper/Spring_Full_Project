package com.matrix.Spring.repository;

import com.matrix.Spring.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RepositoryManager {
    @PersistenceContext
    EntityManager entityManager;

    public List<ProductEntity> getProductLimitter(int limit){
        return entityManager.createQuery("SELECT p from ProductEntity p order by p.homeScore", ProductEntity.class).
                setMaxResults(limit).getResultList();
    }
}
