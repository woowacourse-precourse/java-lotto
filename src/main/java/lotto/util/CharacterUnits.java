package lotto.util;

public enum CharacterUnits {
    ENTER("\n"),
    COMMA(","),
    SPACE(" "),
    LEFT_CASE("["),
    RIGHT_CASE("]"),
    PERCENT("%");

    private final String unit;

    CharacterUnits(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
