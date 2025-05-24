package com.sportgame.gamelist.services;

import com.sportgame.gamelist.Projections.GameMinProjection;
import com.sportgame.gamelist.dto.GameDTO;
import com.sportgame.gamelist.dto.GameMinDTO;
import com.sportgame.gamelist.entities.Game;
import com.sportgame.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    //injecao de dependencia
@Autowired
private GameRepository gameRepository;


//garanta que a transação vai acontecer (ASID)  readOnly =assegura que não vai fazer nenhuma operação para escrita
@Transactional(readOnly = true)
    public GameDTO findById (Long id){

        Game result =gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
        //Fazer tratamento de excessao
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
     List<Game> result =  gameRepository.findAll();
     return  result.stream().map(x -> new GameMinDTO(x)).toList();

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result =  gameRepository.searchByList(listId);
        return  result.stream().map(x -> new GameMinDTO(x)).toList();

    }






}
