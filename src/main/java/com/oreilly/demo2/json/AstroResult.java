package com.oreilly.demo2.json;

import java.util.List;

public class AstroResult {

    private String message;
    private int number;
    private List<Assignment> people;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPeople(List<Assignment> people) {
        this.people = people;
    }

    public String getMessage() {
        return message;
    }
    public int getNumber() {
        return number;
    }
    public List<Assignment> getPeople() {
        return people;
    }
}
