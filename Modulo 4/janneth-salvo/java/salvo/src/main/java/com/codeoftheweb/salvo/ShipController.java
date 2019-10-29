package com.codeoftheweb.salvo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")

public class ShipController {

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ShipRepository shipRepository;


    @RequestMapping("/games/players/{gpid}/ships")
    public ResponseEntity<Map> addship(@PathVariable long gpid, @RequestBody
    Set<Ship> ships, Authentication authentication){
        if (isGuest(authentication)){
            return new ResponseEntity<>(makeMap("ERROR","NO ESTA AUTORIZADO"), HttpStatus.UNAUTHORIZED);
        }
        Player player=playerRepository.findByEmail(authentication.getUserName()).orElse(null);
        GamePlayer gamePlayer = gamePlayerRepository.getOne(gpid);

        if (player == null){
            return new ResponseEntity<>(makeMap("ERROR","NO ESTA AUTORIZADO"), HttpStatus.UNAUTHORIZED);
        }

        if (gamePlayer == null){
            return new ResponseEntity<>(makeMap("ERROR","NO ESTA AUTORIZADO"), HttpStatus.UNAUTHORIZED);
        }

        if (gamePlayer.getPlayer().getId() != player.getId()){
            return new ResponseEntity<>(makeMap("error","los players no coinciden"),HttpStatus.FORBIDDEN);
        }

        if (!gamePlayer.getShips().isEmpty()){
            return new ResponseEntity<>(makeMap("ERROR","NO ESTA AUTORIZADO YA TENGO SHIP"), HttpStatus.UNAUTHORIZED);
        }

        ships.forEach(ship -> {
            ship.setGamePlayer(gamePlayer);
            shipRepository.save(ship);
        });

        return new ResponseEntity<>(makeMap("ok","ship created"),HttpStatus.CREATED);

    }

    private boolean isGuest(Authentication authentication) {
        return authentication == null || authentication instanceof AnonymousAuthenticationToken;
    }

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }


}
