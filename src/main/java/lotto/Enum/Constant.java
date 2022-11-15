package lotto.Enum;

public enum Constant {
    HUNDRED("100"),

    THOUSAND_MODULAR_ZERO("0"),

    ALL_DRAWN_NUMBERS_LENGTH("7"),

    BONUS_NUMBER_MATCHED("1"),

    FIFTH_GRADE_COUNT("3"),
    FOURTH_GRADE_COUNT("4"),
    THIRD_GRADE_COUNT("5"),
    FIRST_GRADE_COUNT("6"),
    SECOND_GRADE_COUNT("7"),
    ZERO_COUNT("0"),

    ZERO_PRIZE("0"),
    FIFTH_GRADE_PRIZE("5000"),
    FOURTH_GRADE_PRIZE("50000"),
    THIRD_GRADE_PRIZE("1500000"),
    FIRST_GRADE_PRIZE("2000000000"),
    SECOND_GRADE_PRIZE("30000000"),

    ZERO_INDEX("0"),
    ONE_INDEX("1"),

    LOTTO_PURCHASE_MIN("1000"),
    LOTTO_PURCHASE_MAX("100000"),

    LOTTO_NUMBER_COUNT("6"),
    LOTTO_NUMBER_MIN("1"),
    LOTTO_NUMBER_MAX("45"),

    REGEX_ONLY_NUMBER("[0-9]+"),
    REGEX_WINNING_NUMBER_FORMAT("(\\d+,){5}\\d+"),
    REGEX_BONUS_NUMBER_FORMAT("\\d+"),

    SPACE(" "),
    EMPTY(""),

    MESSAGE_PURCHASE("개를 구매했습니다."),
    ;

    final private String value;

    Constant(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public int getIntValue() {
        return Integer.parseInt(value);
    }
}
