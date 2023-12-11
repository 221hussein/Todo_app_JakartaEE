package com.hussein.todoapp_test.service;

import com.hussein.todoapp_test.model.Todo;
import com.hussein.todoapp_test.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> findAll(
            int startingPage,
            int pageSize) {
        startingPage = startingPage * pageSize;
        return entityManager.createNamedQuery(User.FIND_ALL_USER, User.class)
                .setFirstResult(startingPage)
                .setMaxResults(pageSize)
                .getResultList();
    }


    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    public User update(Long id, User user) {
        User userToUpdate = getById(id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        return userToUpdate;
    }

    public User updateUsersTodoList(Long id, User user) {
        User userToUpdate = getById(id);
        List<Todo> todoList = user.getTodo();
        userToUpdate.setTodo(todoList);
        return userToUpdate;
    }

    public void delete(Long id) {
        User userToDelete = getById(id);
        entityManager.remove(userToDelete);
    }
}
