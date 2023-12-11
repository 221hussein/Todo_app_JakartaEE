package com.hussein.todoapp_test.controller;

import com.hussein.todoapp_test.model.Todo;
import com.hussein.todoapp_test.service.TodoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

import static jakarta.ws.rs.core.Response.status;

@Path("/todo")
@RequestScoped
public class TodoController {
    @Inject
    private TodoService todoService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/find_by_page")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> findAll(
            @QueryParam("start") int startingPage,
            @QueryParam("pageSize") int pageSize) throws Exception {
        List<Todo> todoInList = todoService.findAll(startingPage, startingPage + pageSize);
        if(todoInList.isEmpty()) {
            throw new Exception ("No Todo found with page " + startingPage + " and page size " + pageSize);
        } else {
            return todoInList;
        }
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Object create( Todo todo) {
        todoService.create(todo);
        System.out.println(todo.getTask());
        return status(Response.Status.CREATED).entity("Todo created successfully").build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create_many")
    public List<Object> createManyTodo(List<Todo> todoList) {
        todoService.createManyTodos(todoList);
        return Collections.singletonList(Response.Status.CREATED);
    }

    @GET
    @Path("/get/{id}")
    public Todo getById(@PathParam("id") Long id) {
        return todoService.getById(id);
    }

}
