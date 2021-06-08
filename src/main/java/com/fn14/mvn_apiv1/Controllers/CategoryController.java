/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Controllers;

import com.fn14.mvn_apiv1.Dto.CategoryDto;
import com.fn14.mvn_apiv1.Dto.ResponseData;
import com.fn14.mvn_apiv1.Models.Category;
import com.fn14.mvn_apiv1.Services.CategoryService;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FN14
 */
@RestController 
@RequestMapping("/api/category") 
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;  
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody CategoryDto categoryDto, Errors errors){
        ResponseData<Category> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(objErr -> {
                responseData.getMessages().add(objErr.getDefaultMessage());
            });
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryDto, Category.class);
        responseData.setStatus(true);
        responseData.getMessages().add("Data Successfully Create");
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData); 
                
    }
    
    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }
    
    @GetMapping("/{id}") 
    public Category findById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }
    
    @PostMapping("/upd")
    public ResponseEntity<ResponseData<Category>> Update(@Valid @RequestBody CategoryDto categoryDto, Errors errors){
        ResponseData<Category> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(objErr -> {
                responseData.getMessages().add(objErr.getDefaultMessage());
            });
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryDto, Category.class);
        responseData.setStatus(true);
        responseData.getMessages().add("Data Successfully Create");
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData); 
                
    }
    
}
