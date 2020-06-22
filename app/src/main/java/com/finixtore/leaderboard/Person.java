package com.finixtore.leaderboard;

public class Person {
    public Person(String name, String points) {
        this.name = name;
        this.points = points;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    String name;
    String points;

}
