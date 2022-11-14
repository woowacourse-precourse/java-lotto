package lotto.type;

public enum PatternType {
    WIN_NUMBER("^(\\s*\\d+\\s*,){%d}\\s*\\d+\\s*$", ConstantNumberType.COUNT.getValue()-1);

    private final String pattern;

    PatternType(String pattern, Object... formatters) {
        this.pattern = String.format(pattern, formatters);
    }

    public String getPattern() {
        return pattern;
    }
}
