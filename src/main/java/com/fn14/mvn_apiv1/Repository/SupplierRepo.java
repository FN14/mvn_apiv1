/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Repository;

import com.fn14.mvn_apiv1.Models.Supplier;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FN14
 */
public interface SupplierRepo extends CrudRepository<Supplier,Long> {
     
}
