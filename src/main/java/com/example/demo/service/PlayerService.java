package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PlayerService {


    @Autowired
    private PlayerRepository playerRepository;

    public Mono<Void> save(Mono<Player> player){
        return player.flatMap(playerRepository::save).then();
    }

    public Flux<Player> findAll(){
        return playerRepository.findAll();
    }
}

