package pl.karnecki.woldcuplivegameboard;

public class GameSummary {
    private final int gameIndex;
    private final String homeTeam;
    private final String awayTeam;
    private final int totalScore;
    private final Game game;

    public GameSummary(int gameIndex, String homeTeam, String awayTeam, int totalScore, Game game) {
        this.gameIndex = gameIndex;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalScore = totalScore;
        this.game = game;
    }

    public int getGameIndex() {
        return gameIndex + 1;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return  homeTeam + ' ' + game.getHomeScore() + " - " + awayTeam +  ' ' + game.getAwayScore();
    }
}
