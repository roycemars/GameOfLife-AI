package org.example.model;

public class GameOfLife {
    private int rows;
    private int cols;
    private boolean[][] grid;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void initializeRandom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Math.random() < 0.5;
            }
        }
    }

    public void update() {
        boolean[][] newGrid = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (grid[i][j]) {
                    newGrid[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    newGrid[i][j] = liveNeighbors == 3;
                }
            }
        }
        grid = newGrid;
    }

    private int countLiveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}