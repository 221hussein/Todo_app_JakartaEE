package com.hussein.todoapp_test.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;

@Path("/task")
@RequestScoped
public class UserWithTask {

    @GET
    public String getUser() {
        return "Hello, World! in task ressorces";
    }
}
