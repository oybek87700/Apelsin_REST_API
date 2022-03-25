package com.example.apelsin_restapi.repository;
import com.example.apelsin_restapi.entity.Customer;
import com.example.apelsin_restapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByActiveTrue();



    @Query(value = "select * from customer inner join orderer o on customer.id = o.cust_id_id where   date ='2016-03-23 16:29:50.000000'; ", nativeQuery = true)
    List<Customer> customers_without_orders();



    @Query(value = "select * from customer\n" +
            "   inner join orderer o on customer.id = o.cust_id_id\n" +
            "WHERE o.date = (\n" +
            "    SELECT MAX(o2.date)\n" +
            "    FROM  orderer o2\n" +
            "    WHERE o2.cust_id_id = o.cust_id_id\n" +
            ");", nativeQuery = true)
    List<Customer> customers_last_orders();





    @Query(value = "select * from customer inner join orderer o on customer.id = o.cust_id_id where date='2016-06-23 12:32:47.000000'", nativeQuery = true)

    List<Customer> number_of_products_in_year();
}
