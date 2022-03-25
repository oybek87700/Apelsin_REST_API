package com.example.apelsin_restapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private boolean active = true;
    private Timestamp date;

    @ManyToOne
    private  Customer custId;
}
