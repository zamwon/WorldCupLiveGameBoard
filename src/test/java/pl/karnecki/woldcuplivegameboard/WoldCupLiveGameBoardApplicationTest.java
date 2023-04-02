package pl.karnecki.woldcuplivegameboard;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WoldCupLiveGameBoardApplicationTest {

    @Test
    void shouldCreateScoreBoard() {
        ScoreBoard scoreBoard = new ScoreBoard();
        assertNotNull(scoreBoard);
    }

    @Test
    void shouldCreateScanner() {
        Scanner scanner = new Scanner(System.in);
        assertNotNull(scanner);
    }
}
