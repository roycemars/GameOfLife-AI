package org.example.controller;

import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public void startGame(@RequestParam int rows, @RequestParam int cols) {
        gameService.startGame(rows, cols);
    }

    @GetMapping("/grid")
    public boolean[][] getGrid() {
        return gameService.getGrid();
    }

    @PostMapping("/update")
    public void updateGame() {
        gameService.updateGame();
    }
}