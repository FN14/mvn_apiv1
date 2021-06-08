/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Services;

import com.fn14.mvn_apiv1.Models.Supplier;
import com.fn14.mvn_apiv1.Repository.SupplierRepo;
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
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;  
    
    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }
    
    public Supplier findById(Long id){
        Optional<Supplier> optSupp = supplierRepo.findById(id);
        if(!optSupp.isPresent()){
            return null;
        }
        return optSupp.get();
    } 
    
    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }
    
    public void removeById(Long id){
        supplierRepo.deleteById(id); 
    }
    
}
