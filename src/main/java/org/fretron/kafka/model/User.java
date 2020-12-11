package org.fretron.kafka.model;

public class User {
    private String firstName;
    private int age;

    User() {
        super();
    }

    public User(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "User(" + firstName + ", " + age + ")";
    }
}