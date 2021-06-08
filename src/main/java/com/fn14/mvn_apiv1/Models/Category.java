/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 
 * @author FN14
 */
@Entity
@Data 
@Table(name="tb_category")
public class Category {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(name="category_name")
    private String name;
    private String description;
}
