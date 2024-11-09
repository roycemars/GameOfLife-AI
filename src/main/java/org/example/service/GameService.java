package org.example.service;

import org.example.model.GameOfLife;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameOfLife game;

    public void startGame(int rows, int cols) {
        game = new GameOfLife(rows, cols);
        game.initializeRandom();
    }

    public boolean[][] getGrid() {
        return game.getGrid();
    }

    public void updateGame() {
        game.update();
    }
}