package lotto;

public enum NumberMatch {
    THREE("3개 일치 (5,000원) - ",5000),
    FORTH("4개 일치 (50,000원) - ", 50000),
    FIFTH("5개 일치 (1,500,000원) - ", 1500000),
    FIFTH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIXTH("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String numberMatch;
    private final int money;

    NumberMatch(String numberMatch, int money) {
        this.numberMatch = numberMatch;
        this.money = money;
    }

    public String getNumberMatch() {
        return this.numberMatch;
    }

    public int getMoney(){
        return this.money;
    }
}
