package com.matrix.Spring.repository;

import com.matrix.Spring.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    @PersistenceContext
    EntityManager em;

    public List<ProductEntity> getProductByHomeLatestAndHomeAbout(String homeLatest, String homeAbout, String homeView){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> productEntityRoot = criteriaQuery.from(ProductEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if(homeLatest != null){
            predicates.add( criteriaBuilder.equal(productEntityRoot.get("homeLatest"),homeLatest));
        }
        if(homeAbout != null){
            predicates.add(criteriaBuilder.equal(productEntityRoot.get("homeAbout"),homeAbout));
        }
        if(homeView != null){
            predicates.add(criteriaBuilder.equal(productEntityRoot.get("homeView"), homeView));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(criteriaQuery).getResultList();

//        Predicate findByHomeLatest = criteriaBuilder.equal(productEntityRoot.get("homeLatest"),homeLatest);
//        Predicate findByHomeAbout = criteriaBuilder.equal(productEntityRoot.get("homeAbout"),homeAbout);
//        Predicate findByHomeView = criteriaBuilder.equal(productEntityRoot.get("homeView"), homeView);
//        criteriaQuery.where(findByHomeLatest,findByHomeAbout,findByHomeView);
//        TypedQuery<ProductEntity> query = em.createQuery(criteriaQuery);
//        return query.getResultList();
    }

//    EntityManager em;
//
//    // constructor
//
//    List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//
//        Root<Book> book = cq.from(Book.class);
//        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
//        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
//        cq.where(authorNamePredicate, titlePredicate);
//
//        TypedQuery<Book> query = em.createQuery(cq);
//        return query.getResultList();
   // }
}
