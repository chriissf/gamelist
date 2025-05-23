package com.sportgame.gamelist.controllers;


import com.sportgame.gamelist.dto.GameDTO;
import com.sportgame.gamelist.dto.GameMinDTO;
import com.sportgame.gamelist.entities.Game;
import com.sportgame.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;

    }

    /*@GetMapping mapeia E @PathVariable garante que /id vai retorna o endereço id */
    @GetMapping (value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;

    }
}
