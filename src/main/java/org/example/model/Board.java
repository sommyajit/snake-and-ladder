package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private List<Snake> snake;
    private List<Ladder> ladders;
    private Map<Player, Integer> player;

    public Board(int size, List<Ladder> ladders, List<Snake> snake) {
        this.size = size;
        this.player = new HashMap<>();
        this.ladders = ladders;
        this.snake = snake;
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnake() {
        return snake;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Map<Player, Integer> getPlayer() {
        return player;
    }
}
