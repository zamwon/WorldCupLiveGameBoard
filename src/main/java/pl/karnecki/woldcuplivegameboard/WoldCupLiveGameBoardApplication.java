package pl.karnecki.woldcuplivegameboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class WoldCupLiveGameBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoldCupLiveGameBoardApplication.class, args);

        final var scoreBoard = new ScoreBoard();
        final var scanner = new Scanner(System.in);

        scoreBoard.run(scanner);
    }
}
