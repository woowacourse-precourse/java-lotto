package service;

public enum Format {
    PURCHASE_AMOUNT("[0-9]+"),
    WINNING_NUMBERS("(([1-9]|[1-3][0-9]|4[0-5]),){5}([1-9]|[1-3][0-9]|4[0-5])");

    private final String regex;

    Format(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
