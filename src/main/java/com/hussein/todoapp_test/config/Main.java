package com.hussein.todoapp_test.config;

import com.hussein.todoapp_test.model.Todo;
import java.util.List;

public class Main {


    public static void main(String[] args) {
    List<Todo> todoList =  List.of(
                new Todo(

                        "Task 1",
                        "Description 1"
                ),
                new Todo(

                        "Task 2",
                        "Description 2"
                ),
                new Todo(

                        "Task 3",
                        "Description 3"
                ),
                new Todo(

                        "Task 4",
                        "Description 4"
                ),
                new Todo(

                        "Task 5",
                        "Description 5"
                )
        );
    }


}
