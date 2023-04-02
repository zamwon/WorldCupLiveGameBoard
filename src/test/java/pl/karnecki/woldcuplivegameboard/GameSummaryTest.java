package pl.karnecki.woldcuplivegameboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameSummaryTest {

    private GameSummary summary1;
    private GameSummary summary2;

    @BeforeEach
    public void setUp() {
        var game1 = new Game("Team A", "Team B");
        game1.setHomeScore(10);
        game1.setAwayScore(5);
        var game2 = new Game("Team C", "Team D");
        game2.setHomeScore(2);
        game2.setAwayScore(3);
        summary1 = new GameSummary(0, "Team A", "Team B", 15, game1);
        summary2 = new GameSummary(1, "Team C", "Team D", 5, game2);
    }

    @Test
    void testGetGameIndex() {
        Assertions.assertEquals(1, summary1.getGameIndex());
        Assertions.assertEquals(2, summary2.getGameIndex());
    }

    @Test
    void testGetHomeTeam() {
        Assertions.assertEquals("Team A", summary1.getHomeTeam());
    }

    @Test
    void testGetAwayTeam() {
        Assertions.assertEquals("Team D", summary2.getAwayTeam());
    }

    @Test
    void testGetTotalScore() {
        Assertions.assertEquals(15, summary1.getTotalScore());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Team A 10 - Team B 5", summary1.toString());
    }
}
