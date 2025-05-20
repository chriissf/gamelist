package com.sportgame.gamelist.repositories;

import com.sportgame.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository <Game , Long>{


}
