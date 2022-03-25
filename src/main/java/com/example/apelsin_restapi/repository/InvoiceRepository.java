package com.example.apelsin_restapi.repository;
import com.example.apelsin_restapi.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findAllByActiveTrue();

    @Query(value = "select * from invoice   inner join orders o on o.id = invoice.ord_id where date>invoice.issued;", nativeQuery = true)
    List<Invoice> wrong_date_invoices();

    @Query(value = "select * from invoice where issued>due ", nativeQuery = true)
    List<Invoice> allByActiveTrue();


    @Query(value = "select * from payment inner join invoice i on i.id = payment.inv_id_id where i.ammount<payment.amount; ", nativeQuery = true)
    List<Invoice> overpaid_invoices();


}
