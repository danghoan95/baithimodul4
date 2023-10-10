package com.example.baithimodul4.service;

import java.util.List;

public interface IGenerateService<E>{
    List<E> findAll();
    E findOne(Long id);
     void save (E e) ;
     void  delete(Long id);
}
