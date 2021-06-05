/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Services;

import com.fn14.mvn_apiv1.Models.Product;
import com.fn14.mvn_apiv1.Repository.ProductRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FN14
 */

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;
    
    public Product create(Product product){
        return productRepo.save(product);
    }
    
    public Product findById(Long id){
        Optional<Product> product = productRepo.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return productRepo.findById(id).get();
    }
    
    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }
    
    public void removeById(Long id){
        productRepo.deleteById(id);
    }
    
    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
    
}
