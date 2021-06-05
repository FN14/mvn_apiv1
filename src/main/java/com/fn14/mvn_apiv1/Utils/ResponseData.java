/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Utils;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author FN14
 * @param <T>
 */
@Data
public class ResponseData<T> {
    
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
