package lotto.util.constants;

public enum WinningScore {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 200_000_0000);

    public final int score;
    public final int money;

    WinningScore(int score, int money) {
        this.score = score;
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }
}
