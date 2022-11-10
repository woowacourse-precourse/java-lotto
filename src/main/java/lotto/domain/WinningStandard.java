package lotto.domain;

public enum WinningStandard {
    FIFTH(3, "5,000"),
    FOURTH(4,"50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5,"30,000,000"),
    FIRST(6,"2,000,000,000");

    private int number;
    private String won;

    public int getNumber() {
        return number;
    }

    public String getWon() {
        return won;
    }

    WinningStandard(int number, String won) {
        this.number = number;
        this.won = won;
    }
}
