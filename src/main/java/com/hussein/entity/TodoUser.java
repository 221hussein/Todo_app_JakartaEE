package com.hussein.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "todo_user_table")
public class TodoUser extends AbstractEntity {

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;
    private String password;



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
