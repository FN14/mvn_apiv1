/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Controllers;

import com.fn14.mvn_apiv1.Models.Product;
import com.fn14.mvn_apiv1.Services.ProductService;
import com.fn14.mvn_apiv1.Utils.ResponseData;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired 
    private ProductService productService;
      
    @PostMapping
    public ResponseEntity<ResponseData> create(@Valid @RequestBody Product product, Errors errors){
        
        ResponseData<Product> resData = new ResponseData();
        
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(errs -> {
                resData.getMessages().add(errs.getDefaultMessage());
            });
            resData.setStatus(false);
            resData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resData);
        }
        resData.setStatus(true);
        resData.setPayload(productService.create(product));
        return ResponseEntity.ok(resData);
    } 
    
    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }
    
    @GetMapping("/{id}") 
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }
    
    @PostMapping("/upd")
    public ResponseEntity<ResponseData> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> resData = new ResponseData();
        
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(errs -> {
                resData.getMessages().add(errs.getDefaultMessage());
            });
            resData.setStatus(false);
            resData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resData);
        }
        resData.setStatus(true);
        resData.setPayload(productService.create(product));
        return ResponseEntity.ok(resData);
    }
    
    @PostMapping("/del/{id}")
    public void deleteById(@PathVariable("id") Long id){
        productService.removeById(id);
    }
}
