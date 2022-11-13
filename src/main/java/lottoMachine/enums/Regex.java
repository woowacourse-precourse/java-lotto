package lottoMachine.enums;

public enum Regex {
    NUMBER_REGEX("^[0-9]+$"),
    WINNING_NUMBER_REGEX("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
