package lotto.domain;

public enum MoneyUnit {
    FIRST_PRIZE_MONEY(2_000_000_000),
    SECOND_PRIZE_MONEY(30_000_000),
    THIRD_PRIZE_MONEY(1_500_000),
    FOURTH_PRIZE_MONEY(50_000),
    FIFTH_PRIZE_MONEY(5_000),
    NO_PRIZE_MONEY(0)
    ;

    private final Integer unit;

    MoneyUnit(Integer unit) {
        this.unit = unit;
    }

    public static Integer getUnit(int place) {
        return MoneyUnit.values()[place-1].unit;
    }
}
