package com.example.demo.controller;

import com.example.demo.CsvUtilFile;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.util.List;

@RestController
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/listMongo")
    public Flux<Player> findAllPlayers(){
        return playerService.findAll();
    }

    @GetMapping(value = "/listCsv")
    public List<Player> findAll(){
        return CsvUtilFile.getPlayers();
    }

}
