package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
    //@PreAuthorize("hasAuthority('READ')") dada la creacion de los entities, y el service, se puede poner seguridad de esa manera
    public String helloGet(){
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    //@PreAuthorize("hasAuthority('REFACTOR')") otra forma de poner seguridad
    public String helloPatch(){
        return "Hello World - PATCH";
    }

}
