package lotto;

public class Game {
    private int gameNumber;
    private Lotto[] games;

    public Game(int money) {
        this.gameNumber = money % 1000;
        this.games = new Lotto[gameNumber];
    }
}
