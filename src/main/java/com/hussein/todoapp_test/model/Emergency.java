package com.hussein.todoapp_test.model;


import jakarta.persistence.*;

@Entity
public class Emergency {

    @Id
    @SequenceGenerator (
        name = "emergency_sequence",
        sequenceName = "emergency_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "emergency_sequence"
    )
    private Long id;

    private String name;

    public Emergency() {
    }

    public Emergency(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
