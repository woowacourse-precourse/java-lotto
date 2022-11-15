package lotto.exception;

public enum ErrorPrefix {
    IllegalArgumentException("[ERROR]"),;

    private String prefix;

    ErrorPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
