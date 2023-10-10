package com.example.baithimodul4.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String name;
    private LocalDate date;
    private String address;
    private  String phone;
    private  String email;
    @ManyToOne
    private Category category;
}
