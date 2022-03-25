package com.example.apelsin_restapi.repository;

import com.example.apelsin_restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByActiveTrue();



    @Query(value = " select * from product inner join detail d on product.id = d.product_id_id where quantity>=10;", nativeQuery = true)
    List<Product> high_demand_products();


    @Query(value = "select * from product inner join detail d on product.id = d.product_id_id where d.quantity = (select avg(d1.quantity) from detail as d1) and d.quantity>8;", nativeQuery = true)
    List<Product> bulk_products();
}
