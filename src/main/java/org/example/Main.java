package org.example;


import org.example.model.Board;
import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;
import org.example.service.SnakeLadderGameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Snake And Ladder!");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Number of Players:");
            int noOfPlayers = sc.nextInt();
            List<Player> players = new ArrayList<>();
            while (noOfPlayers > 0) {
                System.out.println("Enter Player Name:");
                players.add(new Player(sc.next()));
                noOfPlayers--;
            }
            List<Snake> snakes = new ArrayList<>();
            snakes.add(new Snake(90, 15));
            snakes.add(new Snake(56, 32));
            List<Ladder> ladders = new ArrayList<>();
            ladders.add(new Ladder(18, 67));
            ladders.add(new Ladder(40, 92));
            Board board = new Board(100, ladders, snakes);
            SnakeLadderGameService snakeLadderGameService = new SnakeLadderGameService(board, players);
            snakeLadderGameService.startGame();
        }
    }
}
