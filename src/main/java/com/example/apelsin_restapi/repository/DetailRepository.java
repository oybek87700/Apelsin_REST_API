package com.example.apelsin_restapi.repository;
import com.example.apelsin_restapi.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    List<Detail> findAllByActiveTrue();
    List<Detail> findAllByActiveTrueAndProductId(Integer id);
    List<Detail> findAllByActiveTrueAndOrdId(Integer id);
}
