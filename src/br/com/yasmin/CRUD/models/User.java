package br.com.yasmin.CRUD.models;

import java.util.UUID;

public class User {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private int age;
    public User(final String name, final String email, final int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
