package lotto.resources;

public enum ValidationPattern {
    NUMERIC("[0-9]+"),
    LOTTO_RANGE("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$"),
    WINNING_NUMBER("^([1-9],){5}[1-9]{1}$");

    ValidationPattern(String value) {
        this.value = value;
    }

    private final String value;

    public boolean isValid(String target) {
        return target.matches(this.value);
    }
}
