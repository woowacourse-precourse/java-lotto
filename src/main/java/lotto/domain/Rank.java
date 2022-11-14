package lotto.domain;

public enum Rank {
    NONE(0, 0, 0, ""),
    FIFTH(5, 3, 5000, " (5,000원)"),
    FOURTH(4, 4, 50000, " (50,000원)"),
    THIRD(3, 5, 1500000, " (1,500,000원)"),
    SECOND(2, 5, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST(1, 6, 2000000000, " (2,000,000,000원)");

    private int rankInt;
    private int normalNumbers;
    private int rewardInt;
    private String rewardString;

    Rank(int rankInt, int normalNumbers, int rewardInt, String rewardString) {
        this.rankInt = rankInt;
        this.normalNumbers = normalNumbers;
        this.rewardInt = rewardInt;
        this.rewardString = rewardString;
    }

    public int getRankInt() {
        return rankInt;
    }

    public int getNormalNumbers() {
        return normalNumbers;
    }

    public int getRewardInt() {
        return rewardInt;
    }

    public String getRewardString() {
        return rewardString;
    }
}
