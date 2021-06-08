/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author FN14
 */
@Data 
public class CategoryDto {
    
    @NotEmpty(message="Name is Required")
    private String name;
}
