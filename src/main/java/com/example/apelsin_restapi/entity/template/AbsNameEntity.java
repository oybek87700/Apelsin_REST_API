package com.example.apelsin_restapi.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbsNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean active = true;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updatedAt;
}
