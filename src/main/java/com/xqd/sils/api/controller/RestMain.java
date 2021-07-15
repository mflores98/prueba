package com.xqd.sils.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel F.
 */
@RestController
@RequestMapping("/rest")
public class RestMain {

    @GetMapping(value = "/test")
    public ResponseEntity<?> f(){
        System.out.println("esta prueba publica");
        return ResponseEntity.ok(true);
    }
}
