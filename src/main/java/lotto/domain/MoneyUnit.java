package lotto.domain;

public enum MoneyUnit {
    FIRST_PRIZE_MONEY(2_000_000_000, "2,000,000,000"),
    SECOND_PRIZE_MONEY(30_000_000, "30,000,000"),
    THIRD_PRIZE_MONEY(1_500_000, "1,500,000"),
    FOURTH_PRIZE_MONEY(50_000, "50,000"),
    FIFTH_PRIZE_MONEY(5_000, "5,000"),
    NO_PRIZE_MONEY(0, "0");;

    private final Integer unit;
    private final String unitString;

    MoneyUnit(Integer unit, String unitString) {
        this.unit = unit;
        this.unitString = unitString;
    }

    public static Integer getUnit(int place) {
        return MoneyUnit.values()[place - 1].unit;
    }

    public static String getUnitString(int place) {
        return MoneyUnit.values()[place - 1].unitString;
    }
}
