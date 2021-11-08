package com.emelian.model;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="patient")
public class Patient{

    public Patient() {}

    public Patient(String name, String surname,String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic =patronymic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(max = 100, message = "Name should be before 100 characters")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(max = 150, message = "Surname should be before 150 characters")
    private String surname;

    @NotEmpty(message = "Surname should not be empty")
    @Size(max = 150, message = "Patronymic should be before 150 characters")
    private String patronymic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

}
