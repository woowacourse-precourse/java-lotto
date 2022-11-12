package lotto.model;

public enum Rank {
    NO_5(5_000, "3개 일치 (5,000원)"),
    NO_4(50_000,"4개 일치 (50,000원)"),
    NO_3(1_500_000,"5개 일치 (1,500,000원)"),
    NO_2(30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    NO_1(2_000_000_000, "6개 일치 (2,000,000,000원)");

    public static String toRankName(int rankValue) {
        return "NO_" + rankValue;
    }

    Rank(long prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    private final long prize;
    private final String description;

    public long calculateTotalPrize(int count) {
        return this.prize*count;
    }

    public String getDescription() {
        return this.description;
    }
}

