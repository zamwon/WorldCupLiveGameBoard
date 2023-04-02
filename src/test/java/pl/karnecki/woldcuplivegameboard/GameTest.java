package pl.karnecki.woldcuplivegameboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game1;
    private Game game2;

    @BeforeEach
    public void setUp() {
        game1 = new Game("Team A", "Team B");
        game2 = new Game("Team C", "Team D");
    }

    @Test
    void testGetHomeTeam() {
        Assertions.assertEquals("Team A", game1.getHomeTeam());
    }

    @Test
    void testGetAwayTeam() {
        Assertions.assertEquals("Team D", game2.getAwayTeam());
    }

    @Test
    void testSetHomeScore() {
        game1.setHomeScore(10);
        Assertions.assertEquals(10, game1.getHomeScore());
    }

    @Test
    void testSetAwayScore() {
        game1.setAwayScore(5);
        Assertions.assertEquals(5, game1.getAwayScore());
    }

    @Test
    void testToString() {
        game1.setHomeScore(10);
        game1.setAwayScore(5);
        Assertions.assertEquals("Team A 10 - Team B 5", game1.toString());
    }
}
