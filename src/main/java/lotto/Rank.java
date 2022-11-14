package lotto;

public enum Rank {

    FIRST(2000000000, "6개 일치 (2,000,000,000원)", 6),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5),
    THIRD(1500000, "5개 일치 (1,500,000원)", 5),
    FOURTH(50000, "4개 일치 (50,000원)", 4),
    FIFTH(5000, "3개 일치 (5,000원)", 3),
    NOTHING(0, "", 0);

    private int money;
    private String scoreText;
    private int matchNumber;

    Rank(int money, String scoreText, int matchNumber) {
        this.money = money;
        this.scoreText = scoreText;
        this.matchNumber = matchNumber;
    }

    public int getMoney() {
        return money;
    }

    public String getScoreText() {
        return scoreText;
    }

    public int getMatchNumber() {
        return matchNumber;
    }
}
