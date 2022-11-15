package lotto.constant;

public enum RegularExpression {
    ONLY_NUMBER("-?\\d+(\\.\\d+)?");

    private final String regex;

    RegularExpression(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
