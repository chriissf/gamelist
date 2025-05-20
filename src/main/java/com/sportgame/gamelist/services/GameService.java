package com.sportgame.gamelist.services;

import com.sportgame.gamelist.dto.GameMinDTO;
import com.sportgame.gamelist.entities.Game;
import com.sportgame.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

@Autowired
private GameRepository gameRepository;

public List<GameMinDTO> findAll(){
   List<Game> result =  gameRepository.findAll();
   return  result.stream().map(x -> new GameMinDTO(x)).toList();

    }

}
