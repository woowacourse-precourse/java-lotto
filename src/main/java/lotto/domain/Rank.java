package lotto.domain;

public enum Rank {
    THREE(3, false, 5000, " (5,000원)"),
    FOUR(4, false, 50000, " (50,000원)"),
    FIVE(5, false, 1500000, " (1,500,000원)"),
    FIVEBONUS(5, true, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2000000000, " (2,000,000,000원)");

    private int matchCnt;
    private boolean havePlusLotto;
    private int money;
    private String message;
    private int amount;

    Rank(int matchCnt, boolean havePlusLotto, int money, String message) {
        this.matchCnt = matchCnt;
        this.havePlusLotto = havePlusLotto;
        this.money = money;
        this.message = message;
    }

    public boolean isHavePlusLotto() {
        return havePlusLotto;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return matchCnt + "개 일치" + message + " - " + amount + "개";
    }

}
