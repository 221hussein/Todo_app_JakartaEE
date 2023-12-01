package com.hussein.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "todo_table")
public class Todo extends AbstractEntity {

    @NotEmpty(message = "Task must not be empty")
    @Size(min = 5, max = 100, message = "Task must be between 5 and 100 characters")
    private String task;
    private LocalDate dateCreated;
    @NotNull(message = "Due date must not be empty")
    @FutureOrPresent(message = "Due date must be present or in the future")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate;

    private boolean isCompleted;
    private boolean archived;
    private boolean reminder;

    @ManyToOne()
    @JoinColumn(name ="todoUser_id")
    private TodoUser todoOwner;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public TodoUser getTodoOwner() {
        return todoOwner;
    }

    public void setTodoOwner(TodoUser todoOwner) {
        this.todoOwner = todoOwner;
    }
}
