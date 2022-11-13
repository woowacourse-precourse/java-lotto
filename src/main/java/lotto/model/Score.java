package lotto.model;

public enum Score {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);


    final private Integer money;
    public Integer getMoney() {
        return money;
    }
    private Score(Integer money) {
        this.money = money;
    }
}
