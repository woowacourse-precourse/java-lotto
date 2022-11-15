package lotto.domain;

public enum LottoGrade {
    FIVE( 5_000L),
    FOUR(50_000L),
    THREE(1_500_000L),
    TWO(30_000_000L),
    ONE(2_000_000_000L),
    MISS(0L);

    private final Long price;

    LottoGrade(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public static LottoGrade getRank(int matchNum, boolean bonusBall) {
        if (matchNum == 6) return ONE;
        if (matchNum == 5) {
            if (bonusBall) {
                return TWO;
            }
            return THREE;
        }
        if (matchNum == 4) return FOUR;
        if (matchNum == 3) return FIVE;
        return MISS;
    }
}
