package util;

public enum GameStatus {
    COMMA(","),
    EMPTY(""),
    UNIT("개"),
    PATTERN("\\B(?=(\\d{3})+(?!\\d))");

    private final String code;

    GameStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
