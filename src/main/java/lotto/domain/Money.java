package lotto.domain;

public enum Money {

    FIRST(2_000_000_000),SECOND(30_000_000),THIRD(1_500_000),FOURTH(50_000),FIFTH(5_000);
    private final Integer description;

    Money(Integer description) {
        this.description = description;
    }

    public Integer getDescription() {
        return description;
    }
}
