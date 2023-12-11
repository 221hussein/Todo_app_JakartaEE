package com.hussein.todoapp_test.repository;


import com.hussein.todoapp_test.model.Todo;

import java.util.List;

public interface CrudImpl {

    List<Todo> findAll (int startingPage, int pageSize);

    Object create (Object object);

    Object createManyTodos(List<Object> objectList);

    Object createUserWithTodos(Object object);

    Object update(Long id, Object object);

    Object getById(Long id);

    Object delete(Long id);

    Object updateUsersTodoList(Long id, Object object);
}
