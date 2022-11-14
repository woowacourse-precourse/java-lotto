package lotto.domain;

public enum Ranking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ", false),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - ", false),
    FOURTH(4, 50000, "4개 일치 (50,000원) - ", false),
    FIFTH(3, 5000, "3개 일치 (5,000원) - ", false);

    private int match, prize;
    private String description;
    private boolean bonusMatch;

    Ranking(int match, int prize, String description, boolean bonusMatch) {
        this.match = match;
        this.prize = prize;
        this.description = description;
        this.bonusMatch = bonusMatch;
    }

    public int getMatch() {
        return this.match;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getDescription() {
        return this.description;
    }
    public boolean getBonusMatch() {
        return this.bonusMatch;
    }

}
