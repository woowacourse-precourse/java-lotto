package lotto;

public enum PrizeMoney {
    RANK5("3개 일치 (5,000원)", 5000L),
    RANK4("4개 일치 (50,000원)", 50000L),
    RANK3("5개 일치 (1,500,000원)", 1500000L),
    RANK2("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000L),
    RANK1("6개 일치 (2,000,000,000원)", 2000000000L);

    private final String label;
    private final Long money;

    PrizeMoney(String label, Long money) {
        this.label = label;
        this.money = money;
    }

    public String getLabel() {
        return label;
    }

    public Long getMoney() {
        return money;
    }
}
