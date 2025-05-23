package com.sportgame.gamelist.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_game_list")
public class GameList {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nome;

    public GameList() {
    }

    public GameList(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
