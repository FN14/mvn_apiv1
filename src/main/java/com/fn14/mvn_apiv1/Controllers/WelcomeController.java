/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn14.mvn_apiv1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FN14
 */

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    
    @GetMapping
    public String welcome(){
        return "Hi Gaes, Wellcome to api v1 FN14";
    }
    
}
