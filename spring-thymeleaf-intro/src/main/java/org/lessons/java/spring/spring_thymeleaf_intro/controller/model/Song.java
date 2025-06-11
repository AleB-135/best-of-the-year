package org.lessons.java.spring.spring_thymeleaf_intro.controller.model;

import java.io.Serializable;

public class Song implements Serializable{

    private String titolo;
    private int id;

    public Song(){}


    public Song(String titolo, int id) {
        this.titolo = titolo;
        this.id = id;
    }


    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.titolo;
    }

    
}
