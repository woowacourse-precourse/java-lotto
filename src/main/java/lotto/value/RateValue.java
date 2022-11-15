package lotto.value;

public enum RateValue {
    PERCENT("%", 100);

    private final String rateChar;
    private final int percentage;

    RateValue(String rateChar, int percentage) {
        this.rateChar = rateChar;
        this.percentage = percentage;
    }

    public String getRateChar() {
        return rateChar;
    }

    public int getPercentage() {
        return percentage;
    }
}
