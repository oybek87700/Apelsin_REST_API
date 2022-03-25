package com.example.apelsin_restapi.repository;
import com.example.apelsin_restapi.entity.Invoice;
import com.example.apelsin_restapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByActiveTrue();
    List<Order> findAllByCustIdActive(Integer id);

    @Query(value = "select * from  orders where date < '2016-05-30 05:25:29.000000'; ", nativeQuery = true)
    List<Order> orders_without_details();


    @Query(value = "select * from customer inner join orders o on customer.id = o.cust_id_id inner join detail d on o.id = d.ord_id_id inner join invoice i on o.id = i.ord_id inner join product p on p.id = d.product_id_id ", nativeQuery = true)
    List<Order> orders_without_invoices();
}
