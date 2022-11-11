package lotto.domain;

public enum PrizeRank {
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, 6),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 5),
    THIRD("5개 일치 (1,500,000원) - ", 1500000, 5),
    FOURTH("4개 일치 (50,000원) - ", 50000, 4),
    FIFTH("3개 일치 (5,000원) - ", 5000, 3);

    private String description;
    private int prizeMoney;
    private int answerCount;

    PrizeRank(String description, int prizeMoney, int answerCount) {
        this.description = description;
        this.prizeMoney = prizeMoney;
        this.answerCount = answerCount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getAnswerCount() {
        return answerCount;
    }
}
