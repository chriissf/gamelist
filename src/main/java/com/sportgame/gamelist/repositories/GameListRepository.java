package com.sportgame.gamelist.repositories;

import com.sportgame.gamelist.entities.Game;
import com.sportgame.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository <GameList, Long>{


}
