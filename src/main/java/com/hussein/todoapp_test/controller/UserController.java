package com.hussein.todoapp_test.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/user")
@RequestScoped
public class UserController {

    @GET
    public String getUser() {
        return "Hello, World!";
    }

}
