/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Repository;

import com.fn14.mvn_apiv1.Models.Product;
import com.fn14.mvn_apiv1.Models.Supplier;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FN14
 */
public interface ProductRepo extends CrudRepository<Product,Long>{
    List<Product> findByNameContains(String name);
    
    @Query("select p from Product p where p.name = :name ")
    public Product findProductByName(@PathParam("name") String name);
    
    @Query("select p from Product p where p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);
    
    @Query("select p from Product p where p.category.id = :categoryId ")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);
    
    @Query("select p from Product p where :paramsupplier MEMBER OF p.suppliers")
    public List<Product> findByProductSupplier(@PathParam("paramsupplier") Supplier paramsupplier);
}
