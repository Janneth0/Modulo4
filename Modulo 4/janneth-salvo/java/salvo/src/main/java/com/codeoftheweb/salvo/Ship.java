package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Ship {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;

  private String type;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "gamePlayer_id")
  private GamePlayer gamePlayer;
  @ElementCollection
  @Column(name = "location")
  private Set<String> locations;

  public Ship() {
  }
  public Ship(String type, GamePlayer gamePlayer, Set<String> locations) {
    this.type = type;
    this.gamePlayer = gamePlayer;
    this.locations = locations;
  }
  public long getId() {
    return id;
  }
  public String getType() {
    return type;
  }
  public GamePlayer getGamePlayer() {
    return gamePlayer;
  }
  public Set<String> getLocations() {
    return locations;
  }
  public void setType(String type) {
    this.type = type;
  }
  public void setGamePlayer(GamePlayer gamePlayer) {
    this.gamePlayer = gamePlayer;
  }
  public void setLocations(Set<String> locations) {
    this.locations = locations;
  }

  public Object makeShipDTO() {
    Map<String,Object> dto=new LinkedHashMap<String, Object>();
    dto.put("type",this.getType());
    dto.put("shipLocations",this.getLocations());
    return dto;
  }
}