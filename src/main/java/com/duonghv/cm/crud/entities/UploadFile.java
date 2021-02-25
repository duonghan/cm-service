package com.duonghv.cm.crud.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class UploadFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String diskPath;
    public String path;

    @JsonCreator
    public UploadFile(int id) {
        this.id = id;
    }
}
