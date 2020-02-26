package com.example.examen.DataBase.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "user_table")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer eventId;
    private String email;
    private String name;
    private String lastName;
    private String telefono;
    private Integer age;

    public UserModel(String name, String email, String lastName, Integer eventId, String telefono, Integer age) {
        this.telefono = telefono;
        this.age = age;
        this.eventId = eventId;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

