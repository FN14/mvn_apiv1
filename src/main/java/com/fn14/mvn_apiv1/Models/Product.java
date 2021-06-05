/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author FN14
 */
@Data
@Entity
@Table(name="tb_product")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Name is required")
    @Column(name="product_name",length=100)
    private String name;
    
    @Column(name="description",length=1000)
    private String description;
    
    private double product_price;
    
}
