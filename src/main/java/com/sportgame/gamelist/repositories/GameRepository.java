package com.sportgame.gamelist.repositories;

import com.sportgame.gamelist.Projections.GameMinProjection;
import com.sportgame.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository <Game , Long>{

    //faz funcionar a consulta em  SQL ao invés do jpql do ORM do jpa '@Query(nativeQuery = true, value = """'
    //Ao usar(nativeQuery = true, value = """') uma consulta sql tem que ser retornado uma interface
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);

}
