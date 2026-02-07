package com.src.ecom.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

}
