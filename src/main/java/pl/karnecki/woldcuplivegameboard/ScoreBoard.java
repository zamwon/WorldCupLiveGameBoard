package pl.karnecki.woldcuplivegameboard;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class ScoreBoard {

    private final List<Game> games = new ArrayList<>();

    public void run(Scanner scanner) {
        while (true) {

            log.info("Select an option:");
            log.info("1. Start a new game");
            log.info("2. Update score");
            log.info("3. Finish game");
            log.info("4. Get summary");
            log.info("5. Exit");

            var option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    log.info("Enter home team:");
                    var homeTeam = scanner.nextLine();
                    log.info("Enter away team:");
                    var awayTeam = scanner.nextLine();
                    this.startNewGame(homeTeam, awayTeam);
                }
                case 2 -> {
                    this.getGames();
                    log.info("Enter game to update:");
                    var gameId = scanner.nextInt() - 1;
                    scanner.nextLine();
                    log.info("Enter home team score:");
                    var homeTeamScore = scanner.nextInt();
                    scanner.nextLine();
                    log.info("Enter away team score:");
                    var awayTeamScore = scanner.nextInt();
                    scanner.nextLine();
                    this.updateScore(gameId, homeTeamScore, awayTeamScore);

                }
                case 3 -> {
                    this.getGames();
                    log.info("Enter game to finish:");
                    var gameId = scanner.nextInt() - 1;
                    this.finishGame(gameId);
                }
                case 4 -> {
                    final var summary = this.getSummaryOrderedByTotalScore();
                    log.info("Summary:");
                    summary.forEach(gameSummary -> log.info("[" + getRankingIndex(summary, gameSummary) + ']' + " " + gameSummary));
                }
                case 5 -> System.exit(0);
                default -> log.info("Invalid option. Please try again.");
            }
        }
    }

    public void startNewGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam));
    }

    public void updateScore(int gameIndex, int homeScore, int awayScore) {
        final var game = games.get(gameIndex);
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
    }

    public void finishGame(int gameIndex) {
        games.remove(gameIndex);
    }

    public List<GameSummary> getSummaryOrderedByTotalScore() {

        List<GameSummary> summaries = new ArrayList<>();

        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            int totalScore = game.getHomeScore() + game.getAwayScore();
            summaries.add(new GameSummary(i, game.getHomeTeam(), game.getAwayTeam(), totalScore, game));
        }
        summaries.sort((summary1, summary2) -> {
            int scoreDiff = summary2.getTotalScore() - summary1.getTotalScore();
            if (scoreDiff != 0) {
                return scoreDiff;
            }
            return summary2.getGameIndex() - summary1.getGameIndex();
        });
        return summaries;
    }

    public void getGames() {
        games.forEach(game -> log.info("[" + getGameIndex(game) + ']' + " " + game));
    }

    private int getGameIndex(final Game game) {
        return games.indexOf(game) + 1;
    }
    private static int getRankingIndex(final List<GameSummary> summary, final GameSummary gameSummary) {
        return summary.indexOf(gameSummary) + 1;
    }
}
