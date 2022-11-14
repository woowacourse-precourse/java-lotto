package lotto.Enum;

public enum Constant {
    ZERO("0"),
    ONE("1"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    FOURTY_FIVE("45"),
    THOUSAND("1000"),
    HUNDRED_THOUSAND("100000"),
    REGEX_ONLY_NUMBER("[0-9]+"),
    REGEX_WINNING_NUMBER_FORMAT("(\\d+,){5}\\d+"),
    REGEX_BONUS_NUMBER_FORMAT("\\d+"),
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
