package lotto.data.type;

public enum RegExType {
    LOTTO_ANSWER("(\\s*\\d\\s*,){5}\\s*\\d\\s*");

    private final String pattern;

    RegExType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return this.pattern;
    }
}
