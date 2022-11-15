package lotto.constant;

public enum TypeConversionConstant {
    SPLIT_EXPRESSION(","),
    ;

    private final String value;

    TypeConversionConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
