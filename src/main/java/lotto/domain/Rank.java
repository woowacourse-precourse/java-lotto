package lotto.domain;

public enum Rank {
    NO_RANK_ZERO(0, 0L, "0"),
    NO_RANK_ONE(0, 0L, "0"),
    NO_RANK_TWO(0, 0L, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000"),
    SECOND(5, 30_000_000L, "30,000,000");


    final private int count;
    final private long prize;
    final private String convertPrize;

    Rank(int count, long prize, String convertPrize) {
        this.count = count;
        this.prize = prize;
        this.convertPrize = convertPrize;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getConvertPrize() {
        return convertPrize;
    }
}
