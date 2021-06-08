/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Services;

import com.fn14.mvn_apiv1.Models.Category;
import com.fn14.mvn_apiv1.Repository.CategoryRepo;
import java.util.Optional;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FN14
 */
@Service
@TransactionScoped 
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;  
    
    public Category save(Category category){
        return categoryRepo.save(category);
    }
    public Category findById(Long id){
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isPresent()){
            return null;
        }
        return category.get();
    }
    
    public Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }
    
    public void removeById(Long id){
        categoryRepo.deleteById(id); 
    }
}
