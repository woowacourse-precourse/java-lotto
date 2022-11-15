package lotto.domain;

public enum Rank {
    FIRST(6, false, "2,000,000,000원", 2000000000),
    SECOND(5, true, "30,000,000원", 30000000),
    THIRD(5, false, "1,500,000원", 1500000),
    FORTH(4, false, "50,000원", 50000),
    FIFTH(3, false, "5,000원", 5000);

    private final int ranking;
    private final boolean bonus;
    private final String message;
    private final int value;
    Rank(int ranking, boolean bonus, String message, int value) {
        this.ranking = ranking;
        this.bonus = bonus;
        this.message = message;
        this.value = value;
    }

    public int getRanking() {
        return this.ranking;
    }

    public boolean getBonus() {
        return this.bonus;
    }

    public String getMessage() {
        return this.message;
    }

    public int getValue() {
        return this.value;
    }


}
