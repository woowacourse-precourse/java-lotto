package lotto.domain;

public enum Hit {
    THREEHIT("3개 일치", "5,000원", 5000),
    FOURHIT("4개 일치", "50,000원", 50000),
    FIVEHIT("5개 일치", "1,500,000원", 1500000),
    FIVEHITANDBONUS("5개 일치, 보너스 볼 일치", "30,000,000원", 30000000),
    SIXHIT("6개 일치", "2,000,000,000원", 2000000000);

    private final String message;
    private final String money;
    private final int value;

    Hit(String message, String money, int value) {
        this.message = message;
        this.money = money;
        this.value = value;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMoney() {
        return this.money;
    }

    public int getValue() {
        return this.value;
    }
}
