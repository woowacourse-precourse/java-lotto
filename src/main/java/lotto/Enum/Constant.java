package lotto.Enum;

public enum Constant {
    HUNDRED(100),

    THOUSAND_MODULAR_ZERO(0),

    ALL_DRAWN_NUMBERS_LENGTH(7),

    BONUS_NUMBER_MATCHED(1),

    THIRD_GRADE_MATCHED_COUNT(5),
    SECOND_GRADE_MATCHED_COUNT(7),

    ZERO_PRIZE(0),
    FIFTH_GRADE_PRIZE(5000),
    FOURTH_GRADE_PRIZE(50000),
    THIRD_GRADE_PRIZE(1500000),
    FIRST_GRADE_PRIZE(2000000000),
    SECOND_GRADE_PRIZE(30000000),

    ZERO_INDEX(0),
    ONE_INDEX(1),

    LOTTO_PURCHASE_MIN(1000),
    LOTTO_PURCHASE_MAX(100000),

    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),

    ;

    final private int value;

    Constant(int value){
        this.value = value;
    }

    public int getIntValue() {
        return value;
    }
}
