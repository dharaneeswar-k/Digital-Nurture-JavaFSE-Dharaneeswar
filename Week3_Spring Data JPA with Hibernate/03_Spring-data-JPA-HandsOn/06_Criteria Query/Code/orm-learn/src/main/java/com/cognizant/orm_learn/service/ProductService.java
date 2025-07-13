package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.repository.ProductRepository;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    public List<Product> searchProducts(Map<String, Object> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        filters.forEach((key, value) -> {
            switch (key) {
                case "ramSize":
                    predicates.add(cb.equal(product.get("ramSize"), value));
                    break;
                case "hddSize":
                    predicates.add(cb.equal(product.get("hddSize"), value));
                    break;
                case "cpu":
                    predicates.add(cb.equal(product.get("cpu"), value));
                    break;
                case "os":
                    predicates.add(cb.equal(product.get("operatingSystem"), value));
                    break;
                case "review":
                    predicates.add(cb.greaterThanOrEqualTo(product.get("customerReview"), (Integer) value));
                    break;
                case "weight":
                    predicates.add(cb.lessThanOrEqualTo(product.get("weight"), (Double) value));
                    break;
                case "cpuSpeed":
                    predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), (Double) value));
                    break;
            }
        });

        cq.select(product).where(cb.and(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }
}