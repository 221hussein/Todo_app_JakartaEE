package com.hussein.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TodoUser extends AbstractEntity {

    @NotEmpty(message = "fullName must not be empty")
    @Size(min=2 , max=50, message = "fullName must be between 2 and 50 characters")
    private String fullName;

    @Column(unique = true)
    @NotEmpty(message = "email mustbe set")
    @Email(message = "email should be valid")
    private String email;


    @NotNull(message = "password must not be empty")
    @Size(min=8 , max=100, message = "password must be between 8 and 50 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
            message = "password must have at least one uppercase, one lowercase and one digit")
    private String password;


//    @OneToMany
//    private final Collection<Todo> todos =
//            new ArrayList<>();


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
