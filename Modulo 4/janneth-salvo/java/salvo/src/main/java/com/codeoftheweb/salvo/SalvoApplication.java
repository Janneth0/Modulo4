package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.SecondaryTable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;


@SpringBootApplication
public class  SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
		@Bean
		public CommandLineRunner initData (PlayerRepository playerRepository,
										   GameRepository gameRepository,
										   GamePlayerRepository gamePlayerRepository,
										   ShipRepository shipRepository,
										   SalvoRepository salvoRepository,
										   ScoreRepository scoreRepository){
			return (args) ->{
	////DATOS DE PLAYER
				Player p1=new Player( "j.bauer@ctu.gov");
				Player p2=new Player( "c.obrian@ctu.gov");
				Player p3=new Player( "kim_bauer@gmail.com");
				Player p4=new Player( "t.almeida@ctu.gov");

				playerRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

	////DATOS DE GAME
				Date date = new Date();
				Date date2 = Date.from(date.toInstant().plusSeconds(3600));
				Date date3 = Date.from(date2.toInstant().plusSeconds(3600));
				Date date4 = Date.from(date3.toInstant().plusSeconds(3600));
				Date date5 = Date.from(date4.toInstant().plusSeconds(3600));
				Date date6 = Date.from(date5.toInstant().plusSeconds(3600));
				Date date7 = Date.from(date6.toInstant().plusSeconds(3600));
				Date date8 = Date.from(date7.toInstant().plusSeconds(3600));

				Game g1 = new Game(date);
				Game g2 = new Game(date2);
				Game g3 = new Game(date3);
				Game g4 = new Game(date4);
				Game g5 = new Game(date5);
				Game g6 = new Game(date6);
				Game g7 = new Game(date7);
				Game g8 = new Game(date8);

				gameRepository.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6,g7,g8));

	///DATOS DE GAMEPLAYER
				//Game1
				GamePlayer gp1 = new GamePlayer(date,g1,p1);
				GamePlayer gp2 = new GamePlayer(date,g1,p2);

				//Game2
				GamePlayer gp3 = new GamePlayer(date,g2,p1);
				GamePlayer gp4 = new GamePlayer(date,g2,p2);

				//Game3
				GamePlayer gp5 = new GamePlayer(date,g3,p2);
				GamePlayer gp6 = new GamePlayer(date,g3,p4);

				//Game4
				GamePlayer gp7 = new GamePlayer(date,g4,p2);
				GamePlayer gp8 = new GamePlayer(date,g4,p3);

				//Game5-------------------------
				GamePlayer gp9 = new GamePlayer(date,g5,p4);
				GamePlayer gp10 = new GamePlayer(date,g5,p1);

				//Game6-------------------
				GamePlayer gp11 = new GamePlayer(date,g6,p3);
				//GamePlayer gp12 = new GamePlayer(date,g6);

				//Game7---------------
				GamePlayer gp13 = new GamePlayer(date,g7,p4);
				//GamePlayer gp14 = new GamePlayer(date,g7,);

				//Game8--------
				GamePlayer gp15 = new GamePlayer(date,g8,p3);
				GamePlayer gp16 = new GamePlayer(date,g8,p4);

				gamePlayerRepository.saveAll(Arrays.asList(gp1,gp2,gp3,gp4,gp5,gp6,gp7,gp8,gp9,gp10,gp11,gp13,gp15,gp16));
				//gamePlayerRepository.save(gp12);
				//gamePlayerRepository.save(gp14);

	///DATOS DE SHIP
			//GAME1
				//SHIP1
				Set<String> location1 =new HashSet<>();
				location1.add("H2, H3, H4");
				Ship ship1=new Ship("Destroyer",gp1,location1);
				//SHIP2
				Set<String> location2 =new HashSet<>();
				location2.add("E1, F1, G1");
				Ship ship2=new Ship("Submarine ",gp1,location2);
				//SHIP3
				Set<String> location3 =new HashSet<>();
				location3.add("B4, B5");
				Ship ship3=new Ship("Patrol Boat",gp1,location3);
				//SHIP4
				Set<String> location4 =new HashSet<>();
				location4.add("B5, C5, D5");
				Ship ship4=new Ship("Destroyer",gp2,location4);
				//SHIP5
				Set<String> location5 =new HashSet<>();
				location5.add("F1, F2");
				Ship ship5=new Ship("Patrol Boat",gp2,location5);
			//GAME2
				//SHIP6
				Set<String> location6 =new HashSet<>();
				location6.add("E1, F1, G1");
				Ship ship6=new Ship("Destroyer",gp3,location6);
				//SHIP7
				Set<String> location7 =new HashSet<>();
				location7.add("C6,C7");
				Ship ship7=new Ship("Patrol Boat",gp3,location7);
				//SHIP8
				Set<String> location8 =new HashSet<>();
				location8.add("A2, A3, A4");
				Ship ship8=new Ship("Submarine",gp4,location8);
				//SHIP9
				Set<String> location9 =new HashSet<>();
				location9.add("G6, H6");
				Ship ship9=new Ship("Patrol Boat",gp4,location9);
			//GAME3
				//SHIP10
				Set<String> location10 =new HashSet<>();
				location10.add("B5, C5, D5");
				Ship ship10=new Ship("Destroyer",gp5,location10);
				//SHIP11
				Set<String> location11 =new HashSet<>();
				location11.add("C6,C7");
				Ship ship11=new Ship("Patrol Boat",gp5,location11);
				//SHIP12
				Set<String> location12 =new HashSet<>();
				location12.add("A2, A3, A4");
				Ship ship12=new Ship("Submarine",gp6,location12);
				//SHIP13
				Set<String> location13 =new HashSet<>();
				location13.add("G6, H6");
				Ship ship13=new Ship("Patrol Boat",gp6,location13);
			//GAME4
				//SHIP14
				Set<String> location14 =new HashSet<>();
				location14.add("B5, C5, D5");
				Ship ship14=new Ship("Destroyer",gp7,location14);
				//SHIP15
				Set<String> location15 =new HashSet<>();
				location15.add("C6,C7");
				Ship ship15=new Ship("Patrol Boat",gp7,location15);
				//SHIP16
				Set<String> location16 =new HashSet<>();
				location16.add("A2, A3, A4");
				Ship ship16=new Ship("Submarine",gp8,location16);
				//SHIP17
				Set<String> location17=new HashSet<>();
				location17.add("G6, H6");
				Ship ship17=new Ship("Patrol Boat",gp8,location17);
			//GAME5
				//SHIP18
				Set<String> location18 =new HashSet<>();
				location18.add("B5, C5, D5");
				Ship ship18=new Ship("Destroyer",gp9,location18);
				//SHIP19
				Set<String> location19 =new HashSet<>();
				location19.add("C6,C7");
				Ship ship19=new Ship("Patrol Boat",gp9,location19);
				//SHIP20
				Set<String> location20 =new HashSet<>();
				location20.add("A2, A3, A4");
				Ship ship20=new Ship("Submarine",gp10,location20);
				//SHIP21
				Set<String> location21 =new HashSet<>();
				location21.add("G6, H6");
				Ship ship21=new Ship("Patrol Boat",gp10,location21);
			//GAME6
				//SHIP22
				Set<String> location22 =new HashSet<>();
				location22.add("B5, C5, D5");
				Ship ship22=new Ship("Destroyer",gp11,location22);
				//SHIP23
				Set<String> location23 =new HashSet<>();
				location23.add("C6,C7");
				Ship ship23=new Ship("Patrol Boat",gp11,location23);
			//GAME8
				//SHIP24
				Set<String> location24 =new HashSet<>();
				location24.add("B5, C5, D5");
				Ship ship24=new Ship("Destroyer",gp15,location24);
				//SHIP25
				Set<String> location25 =new HashSet<>();
				location25.add("C6,C7");
				Ship ship25=new Ship("Patrol Boat",gp15,location25);
				//SHIP26
				Set<String> location26 =new HashSet<>();
				location26.add("A2, A3, A4");
				Ship ship26=new Ship("Submarine",gp16,location26);
				//SHIP27
				Set<String> location27 =new HashSet<>();
				location27.add("G6, H6");
				Ship ship27=new Ship("Patrol Boat",gp16,location27);

				shipRepository.saveAll(Arrays.asList(ship1,ship2,ship3,ship4,ship4,ship5,ship6,ship7,ship8,ship9,ship10,ship11,ship12,ship13,ship14,ship15,ship16,ship17,ship18,ship19,ship20,ship21,ship22,ship23,ship24,ship25,ship26,ship27));


	///DATOS DE SALVO






	///DATOS DE SCORE
				Score score1 = new Score((float) 0.5,date,p1,g1);
				Score score2 = new Score((float) 0.5,date,p2,g1);
				Score score3 = new Score((float) 1,date,p3,g2);
				Score score4 = new Score((float) 0,date,p4,g2);

				scoreRepository.saveAll(Arrays.asList(score1,score2,score3,score4));



			};

		}


}



