package lotto.message;

public enum NumberType {

    ZERO(0),
    ONE(1),

    THREE(3),

    FOUR(4),

    FIVE(5),

    SIX(6),

    TEN(10),

    FORTY_FIVE(45),

    HUNDRED(100),

    NUMBER_OF_PRIZE_TYPE(5),

    FIRST_PRIZE(4),

    SECOND_PRIZE(3),

    THIRD_PRIZE(2),

    FOURTH_PRIZE(1),

    FIFTH_PRIZE(0),

    IN_THOUSANDS(1_000),

    FIRST_PRIZE_REWARD(2_000_000_000 / IN_THOUSANDS.getNumberType()),

    SECOND_PRIZE_REWARD(30_000_000 / IN_THOUSANDS.getNumberType()),

    THIRD_PRIZE_REWARD(1_500_000 / IN_THOUSANDS.getNumberType()),

    FOURTH_PRIZE_REWARD(50_000 / IN_THOUSANDS.getNumberType()),

    FIFTH_PRIZE_REWARD(5_000 / IN_THOUSANDS.getNumberType());

    private final int numberType;

    NumberType(int numberType) {
        this.numberType = numberType;
    }

    public int getNumberType() {
        return numberType;
    }
}
