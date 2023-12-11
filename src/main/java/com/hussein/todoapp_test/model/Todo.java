package com.hussein.todoapp_test.model;

import jakarta.persistence.*;


@Entity
@Table(name = "todo")
@NamedQuery(name =Todo.FIND_ALL_TODO, query = "SELECT td FROM Todo td ")
@NamedQuery(name = Todo.FIND_TODO_BY_ID, query = "SELECT td FROM Todo td WHERE td.id = :id order by td.id asc")
public class Todo {


    public static final String FIND_ALL_TODO = "Todo.findAll";
    public static final String FIND_TODO_BY_ID = "Todo.findById";

    @Id
    @SequenceGenerator(
        name = "todo_sequence",
        sequenceName = "todo_sequence",
        allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "todo_sequence"
    )
    private Long id;

    private String task;

    private String description;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private User OwnerTodo;

    @OneToOne
    private Emergency emergency;



    public Todo() {

    }

    public Todo(String task, String description) {
        this.task = task;
        this.description = description;
    }

    public Todo(Long id, String task, String description, User ownerTodo, Emergency emergency) {
        this.id = id;
        this.task = task;
        this.description = description;
        OwnerTodo = ownerTodo;
        this.emergency = emergency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwnerTodo() {
        return OwnerTodo;
    }

    public void setOwnerTodo(User ownerTodo) {
        OwnerTodo = ownerTodo;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }
}
