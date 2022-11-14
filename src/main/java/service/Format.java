package service;

public enum Format {
    PURCHASE_AMOUNT("[0-9]+");

    private final String regex;

    Format(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
