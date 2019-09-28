package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")
    public List<Map<String,Object>> getGames(){
        return gameRepository.findAll()
                             .stream()
                             .map(Game -> makeGameDTO(Game))
                             .collect(Collectors.toList());
    }
    public Map<String,Object> makeGameDTO(Game game){
        Map<String,Object> dto=new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created",game.getCreationDate().getTime());
        dto.put("gamePlayers",getAllGamePlayers(game.getGamePlayers()));
        return dto;
    }
    public List<Map<String,Object>> getAllGamePlayers(Set<GamePlayer> gamePlayers){
        return gamePlayers
                .stream()
                .map(gamePlayer -> makeGamePlayerDTO(gamePlayer))
                .collect(Collectors.toList());
    }
    public Map<String,Object> makeGamePlayerDTO(GamePlayer gamePlayer){
        Map<String,Object> dto=new LinkedHashMap<String, Object>();
        dto.put("id", gamePlayer.getId());
        dto.put("player", gamePlayer.getPlayer().makePlayerDTO());
        return dto;
    }

    @RequestMapping("/game_view/{nn}")
    public Map<String, Object> getGameViewByGamePlayerId(@PathVariable Long nn){
        GamePlayer gamePlayer=gamePlayerRepository.findById(nn).get();

        Map<String, Object> dto=new LinkedHashMap<>();
        dto.put("id", gamePlayer.getGame().getId());
        dto.put("created", gamePlayer.getGame().getCreationDate());
        dto.put("gamePlayers",gamePlayer.getGame().getGamePlayers()
                                                    .stream()
                                                    .map(gamePlayer1 -> gamePlayer1.makeGamePlayerDTO())
                                                    .collect(Collectors.toList()));
        dto.put("ships", gamePlayer.getShips()
                        .stream()
                        .map(ship -> ship.makeShipDTO())
                        .collect(Collectors.toList()));
        dto.put("salvoes", gamePlayer.getSalvoes()
                           .stream()
                            .map(salvo -> salvo.makeSalvoDTO())
                            .collect(Collectors.toList()));
        return dto;

    }



}
