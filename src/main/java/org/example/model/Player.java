package org.example.model;

import java.util.UUID;

public class Player {
    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Player(String name) {
        this.name = name;
        this.id= UUID.randomUUID().toString();
    }



}
