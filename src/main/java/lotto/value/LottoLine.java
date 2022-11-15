package lotto.value;

public enum LottoLine {
    LOTTO_LINE_START("["),
    LOTTO_LINE_END("]"),

    LOTTO_NUMBER_SEPARATOR(", "),
    LOTTO_NUMBER_DELIMITER(",");

    private final String value;

    LottoLine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
