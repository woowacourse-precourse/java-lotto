package lotto;

public enum LottoGrade {
    FIVE(3, 5_000L),
    FOUR(4, 50_000L),
    THREE(5, 1_500_000L),
    TWO(5, 30_000_000L),
    ONE(6, 2_000_000_000L),
    MISS(0, 0L);

    private int count;
    private Long price;

    LottoGrade(int count, Long price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public Long getPrice() {
        return price;
    }

    public static LottoGrade getRank(int matchNum, boolean bonusBall) {
        if (matchNum == 6) return ONE;
        if (bonusBall) {
            matchNum++;
        }
        if (matchNum == 6) return TWO;
        if (matchNum == 5) return THREE;
        if (matchNum == 4) return FOUR;
        if (matchNum == 3) return FIVE;
        return MISS;
    }
}
