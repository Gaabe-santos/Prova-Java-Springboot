package com.example.clienteapi;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/cliente/v1")
public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Cliente cliente

}
