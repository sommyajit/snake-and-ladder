package org.example.service;

import org.example.model.Board;
import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;

import java.util.*;

public class SnakeLadderGameService {

    private final Board board;
    private final Queue<Player> playerQueue = new LinkedList<>();

    public SnakeLadderGameService(Board board, List<Player> players) {
        this.board = board;
        initializeGame(players);
    }

    private void initializeGame(List<Player> players) {
        for (Player player : players) {
            board.getPlayer().put(player, 0);
            playerQueue.add(player);
        }
    }

    public void startGame() {
        printHeader();
        while (!playerQueue.isEmpty()) {
            Player player = playerQueue.poll();
            if (playTurn(player)) break;
            playerQueue.add(player);
        }
    }

    private boolean playTurn(Player player) {
        int currentPos = board.getPlayer().get(player);
        int diceRoll = DiceRollService.diceRoll();
        int newPos = getNewPosition(currentPos, diceRoll);

        printTurn(player, currentPos, diceRoll, newPos);
        board.getPlayer().put(player, newPos);

        return newPos == board.getSize();
    }

    private int getNewPosition(int currentPos, int diceRoll) {
        int newPos = currentPos + diceRoll;

        if (newPos == board.getSize()) {
            return newPos;
        }

        if (newPos > board.getSize()) {
            return currentPos; // Stay in the same position if exceeded
        }

        return applySnakeOrLadder(newPos);
    }

    private int applySnakeOrLadder(int position) {
        for (Snake snake : board.getSnake()) {
            if (position == snake.getStart()) {
                System.out.println(" Ah! Snake Bite");
                return snake.getEnd();
            }
        }

        for (Ladder ladder : board.getLadders()) {
            if (position == ladder.getStart()) {
                System.out.println(" Yo! Ladder");
                return ladder.getEnd();
            }
        }

        return position;
    }

    private void printHeader() {
        System.out.println("+------------+------------+------------+------------+------------+");
        System.out.println("| Player     | Current Pos | Dice Roll  | New Pos    | Result     |");
        System.out.println("+------------+------------+------------+------------+------------+");
    }

    private void printTurn(Player player, int currentPos, int diceRoll, int newPos) {
        String result = (newPos == board.getSize()) ? "WINNER 🎉" : "-";
        System.out.printf("| %-10s | %-10d | %-10d | %-10d | %-10s |\n",
                player.getName(), currentPos, diceRoll, newPos, result);
    }
}
