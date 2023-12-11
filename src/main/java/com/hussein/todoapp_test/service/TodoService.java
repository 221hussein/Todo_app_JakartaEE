package com.hussein.todoapp_test.service;

import com.hussein.todoapp_test.model.Todo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class TodoService  {

    @PersistenceContext
    EntityManager entityManager;

    public List<Todo> findAll (int startingPage, int pageSize) {
        startingPage = startingPage * pageSize;
        return entityManager.createNamedQuery(Todo.FIND_ALL_TODO, Todo.class)
                .setFirstResult(startingPage)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Transactional
    public Todo create(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    @Transactional
    public Todo createManyTodos(List<Todo> todoList) {
        for (Todo todo : todoList) {
            entityManager.persist(todo);
        }
        return todoList.get(todoList.size() - 1);
    }

    public Todo getById(Long id) {
        try {
            return entityManager.createNamedQuery(Todo.FIND_TODO_BY_ID, Todo.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            throw new RuntimeException("Todo with " + id + " not found");
        }

    }

    public Todo update(Long id, Todo todo) {
        Todo todoToUpdate = getById(id);
        if (todo.getId() != id) {
            todoToUpdate.setTask(todo.getTask());
            todoToUpdate.setDescription(todo.getDescription());
            entityManager.merge(todoToUpdate);
        }
        return todoToUpdate;
    }
}
