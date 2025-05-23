package com.sportgame.gamelist.controllers;


import com.sportgame.gamelist.dto.GameDTO;
import com.sportgame.gamelist.dto.GameListDTO;
import com.sportgame.gamelist.dto.GameMinDTO;
import com.sportgame.gamelist.dto.ReplacementDTO;
import com.sportgame.gamelist.entities.GameList;
import com.sportgame.gamelist.services.GameListService;
import com.sportgame.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

    @GetMapping ("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }


    @PostMapping ("/{listId}/replacement")
    public void move (@PathVariable Long listId,@RequestBody ReplacementDTO body){

        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }



}
