package pl.karnecki.woldcuplivegameboard;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    void testStartNewGame() {
        scoreBoard.startNewGame("Team A", "Team B");
        assertEquals(1, scoreBoard.getSummaryOrderedByTotalScore().size());
    }

    @Test
    void testUpdateScore() {
        scoreBoard.startNewGame("Team A", "Team B");
        scoreBoard.updateScore(0, 10, 5);
        assertEquals(15, scoreBoard.getSummaryOrderedByTotalScore().get(0).getTotalScore());
    }

    @Test
    void testFinishGame() {
        scoreBoard.startNewGame("Team A", "Team B");
        scoreBoard.finishGame(0);
        assertEquals(0, scoreBoard.getSummaryOrderedByTotalScore().size());
    }

    @Test
    void testGetSummaryOrderedByTotalScore() {
        var scoreBoard = new ScoreBoard();
        scoreBoard.startNewGame("Team A", "Team B");
        scoreBoard.updateScore(0, 3, 1);

        scoreBoard.startNewGame("Team C", "Team D");
        scoreBoard.updateScore(1, 2, 2);

        scoreBoard.startNewGame("Team E", "Team F");
        scoreBoard.updateScore(2, 0, 0);

        List<GameSummary> summaries = scoreBoard.getSummaryOrderedByTotalScore();

        assertEquals(3, summaries.size());

        assertEquals("Team C", summaries.get(0).getHomeTeam());
        assertEquals("Team D", summaries.get(0).getAwayTeam());

        assertEquals(4, summaries.get(0).getTotalScore());

        assertEquals("Team A", summaries.get(1).getHomeTeam());
        assertEquals("Team B", summaries.get(1).getAwayTeam());
        assertEquals(4, summaries.get(1).getTotalScore());

        assertEquals("Team E", summaries.get(2).getHomeTeam());
        assertEquals("Team F", summaries.get(2).getAwayTeam());
        assertEquals(0, summaries.get(2).getTotalScore());
    }
}
