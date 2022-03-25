package com.example.apelsin_restapi.entity;

import com.example.apelsin_restapi.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category extends AbsEntity {
   private String name;
}
