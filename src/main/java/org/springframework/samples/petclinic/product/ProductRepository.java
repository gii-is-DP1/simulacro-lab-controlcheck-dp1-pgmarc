package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    @Query("SELECT ptypes from ProductType ptypes")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    @Query("SELECT ptype FROM ProductType ptype where ptype.name = ?1")
    ProductType findProductTypeByName(String name);
    @Query("SELECT product from Product product where product.price < ?1")
    List<Product> findProductLessThan(double cost);
}
