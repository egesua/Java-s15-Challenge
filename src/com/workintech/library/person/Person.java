package com.workintech.library.person;

import com.workintech.library.person.person_enums.Role;

import java.util.Objects;

public class Person {
    private long id;
    private String fullName;
    private Role role;

    public Person(long id, String fullName, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(fullName, person.fullName) && Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }
}
