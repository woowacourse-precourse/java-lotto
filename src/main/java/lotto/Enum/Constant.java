package lotto.Enum;

public enum Constant {
    ZERO("0"),
    SIX("6"),
    FOURTY_FIVE("45"),
    THOUSAND("1000"),
    HUNDRED_THOUSAND("100000"),
    REGEX_ONLY_NUMBER("[0-9]+"),
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
