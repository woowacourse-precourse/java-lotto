package lotto.value;

public enum CountValue {
    
    COUNT_DIVIDER(" - "),
    COUNT_UNIT("개");

    private final String value;

    CountValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
