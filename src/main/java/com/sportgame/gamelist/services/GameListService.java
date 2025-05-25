package com.sportgame.gamelist.services;

import com.sportgame.gamelist.Projections.GameMinProjection;
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

@Autowired
private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
     List<GameList> result =  gameListRepository.findAll();
     return  result.stream().map(x -> new GameListDTO(x)).toList();

    }
    @Transactional
    public void move(long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list =  gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        //achar o minimo ->Origem é menor que DESTINO  então minimo é origem caso ao contrario.
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        //achar o maximo ->                     então maximo é  destino, caso ao contrario é minimo  .
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){

            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }

    }

}
