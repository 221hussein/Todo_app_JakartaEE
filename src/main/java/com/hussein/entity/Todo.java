package com.hussein.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todo_table")
public class Todo extends AbstractEntity{
    private String task;
    private LocalDate dateCreated;
    private LocalDate dueDate;
    private boolean isCompleted;
    private boolean archived;
    private boolean reminder;
    @ManyToOne(

    )
    private TodoUser todoOwner;


}
