package com.duonghv.cm.crud.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Where(clause="published=1")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public boolean published = true;


    public Category() {}

    @JsonCreator
    public Category(int id) {
        this.id = id;
    }
}
