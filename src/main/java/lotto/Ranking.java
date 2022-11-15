package lotto;

public enum Ranking {
    FIRST(1, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD(3, "5개 일치 (1,500,000원)", 1500000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    FIFTH(5, "3개 일치 (5,000원)", 5000);

    private final int ranking;
    private final String match;
    private final int money;

    Ranking(int ranking, String match, int money) {
        this.ranking = ranking;
        this.match = match;
        this.money = money;
    }

    public int getRanking() {
        return ranking;
    }

    public String getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }
}
