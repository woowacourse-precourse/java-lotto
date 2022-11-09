package lotto.resources;

public enum ValidationPattern {
    PATTERN("[0-9]+");

    ValidationPattern(String value) {
        this.value = value;
    }

    private final String value;

    public boolean canConvert(String payment) {
        return payment.matches(this.value);
    }
}
