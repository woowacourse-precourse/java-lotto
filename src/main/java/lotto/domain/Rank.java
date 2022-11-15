package lotto.domain;

public enum Rank {
    FIRST(6, "", "(2,000,000,000원)", 2000000000),
    SECOND(5, ", 보너스 볼 일치 ", "(30,000,000원)", 30000000),
    THIRD(5, "", "(1,500,000원)", 1500000),
    FORTH(4, "", "(50,000원)", 50000),
    FIFTH(3, "", "(5,000원)", 5000);

    private final int ranking;
    private final String bonus;
    private final String money;
    private final int value;
    Rank(int ranking, String bonus, String money, int value) {
        this.ranking = ranking;
        this.bonus = bonus;
        this.money = money;
        this.value = value;
    }

    public int getRanking() {
        return this.ranking;
    }

    public String getBonus() {
        return this.bonus;
    }

    public String getMoney() {

        return this.money;
    }

    public int getValue() {
        return this.value;
    }


}
