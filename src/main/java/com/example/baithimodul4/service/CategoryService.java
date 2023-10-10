package com.example.baithimodul4.service;

import com.example.baithimodul4.model.Category;
import com.example.baithimodul4.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository ;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Long id) {

    }
}
