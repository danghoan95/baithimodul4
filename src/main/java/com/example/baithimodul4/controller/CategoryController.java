package com.example.baithimodul4.controller;

import com.example.baithimodul4.model.Category;
import com.example.baithimodul4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService ;
    @GetMapping
    public ResponseEntity<List<Category>> findAll (){
        return  new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public  ResponseEntity<Category> findOne (@PathVariable Long id){
        Category category =categoryService.findOne(id);
        if(category != null){
            return  new ResponseEntity<>(category,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
