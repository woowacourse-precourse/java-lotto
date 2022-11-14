package lotto.domain;

public enum Rank {
    THREE(3, 5000, " (5,000원)"),
    FOUR(4, 50000, " (50,000원)"),
    FIVE(5, 1500000, " (1,500,000원)"),
    FIVEBONUS(5, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2000000000, " (2,000,000,000원)");

    private int matchCnt;
    private int money;
    private String message;

    Rank(int matchCnt, int money, String message) {
        this.matchCnt = matchCnt;
        this.money = money;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return matchCnt + "개 일치" + message + " - ";
    }

}
