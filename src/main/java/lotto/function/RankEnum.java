package lotto.function;

public enum RankEnum {
    FIVE(3, "3개 일치 (5,000원)", 5000)
    , FOUR(4, "4개 일치 (50,000원)", 50000)
    , THREE(5, "5개 일치 (1,500,000원)", 1500000)
    , TWO(6, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000)
    , ONE(7, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int value;
    private final int money;
    private final String message;


    RankEnum(int value, String message, int money) {
        this.value = value;
        this.money = money;
        this.message = message;
    }

    public int value() {
        return value;
    }

    public int money() {
        return money;
    }

    public String message() {
        return message;
    }
}
