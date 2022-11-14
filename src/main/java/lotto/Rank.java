package lotto;

public enum Rank {

    FIRST("1등"),
    SECOND("2등"),
    THIRD("3등"),
    FOURTH("4등"),
    FIFTH("5등");

    private final String message;

    Rank(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
