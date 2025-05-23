package com.sportgame.gamelist.services;

import com.sportgame.gamelist.dto.GameDTO;
import com.sportgame.gamelist.dto.GameListDTO;
import com.sportgame.gamelist.dto.GameMinDTO;
import com.sportgame.gamelist.entities.Game;
import com.sportgame.gamelist.entities.GameList;
import com.sportgame.gamelist.repositories.GameListRepository;
import com.sportgame.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    //injecao de dependencia
@Autowired
private GameListRepository gameListRepository;




    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
     List<GameList> result =  gameListRepository.findAll();
     return  result.stream().map(x -> new GameListDTO(x)).toList();

    }



}
