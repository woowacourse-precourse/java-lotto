package lotto;


import java.text.DecimalFormat;

public enum Rank {
    FIFTH(5, 3, 5000, " (5,000원)"),
    FOURTH(4, 4, 50000, " (50,000원)"),
    THIRD(3, 5, 1500000, " (1,500,000원)"),
    SECOND(2, 5, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST(1, 6, 2000000000, " (2,000,000,000원)"),
    UN_RANK(0, 0, 0, "");

    private final int ranking;
    private final int matchedNumberCount;
    private final int prize;
    private final String rewardString;
    private int count;


    Rank(int ranking, int matchedNumberCount, int reward, String rewardString) {
        this.ranking = ranking;
        this.matchedNumberCount = matchedNumberCount;
        this.prize = reward;
        this.rewardString = rewardString;
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    public String toString() {

        return matchedNumberCount + "개 일치" + rewardString + " - " + count + "개";
    }

    public int getMatchedNumberCount() {

        return matchedNumberCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public int getRanking() {
        return ranking;
    }
}