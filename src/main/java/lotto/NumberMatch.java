package lotto;

public enum NumberMatch {
    THREE("3개 일치 (5,000원) - ",5000, 3),
    FORTH("4개 일치 (50,000원) - ", 50000, 4),
    FIFTH("5개 일치 (1,500,000원) - ", 1500000, 5),
    FIFTH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 7),
    SIXTH("6개 일치 (2,000,000,000원) - ", 2000000000, 6);

    private final String numberMatch;
    private final int money;
    private final int order;

    NumberMatch(String numberMatch, int money, int order) {
        this.numberMatch = numberMatch;
        this.money = money;
        this.order = order;
    }

    public String getNumberMatch() {
        return this.numberMatch;
    }

    public int getMoney(){
        return this.money;
    }

    public int getOrder(){
        return this.order;
    }
}
