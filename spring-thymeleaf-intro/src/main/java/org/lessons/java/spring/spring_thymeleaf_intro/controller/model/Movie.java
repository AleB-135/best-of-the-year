package org.lessons.java.spring.spring_thymeleaf_intro.controller.model;

import java.io.Serializable;

public class Movie implements Serializable{
    private String titolo;
    private int id;


    public Movie(){}

    public Movie(String titolo, int id) {
        this.id = id;
        this.titolo = titolo;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return  this.titolo;
    }

}
