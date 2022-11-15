package lotto.model;

public enum Prize {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5,1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4,50000, "4개 일치 (50,000원)"),
    FIFTH(3,5000, "3개 일치 (5,000원)");

    final private int matches;
    final private int money;
    final private String message;

    private Prize(int matches, int money, String message){
        this.matches = matches;
        this.money = money;
        this.message = message;
    }

    public int getMatches() {
        return matches;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}
