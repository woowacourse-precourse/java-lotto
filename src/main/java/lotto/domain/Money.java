package lotto.domain;

public enum Money {

    FIRST(2_000_000_000,6),
    SECOND(30_000_000,7),
    THIRD(1_500_000,5),
    FOURTH(50_000,4),
    FIFTH(5_000,3);
    private final Integer description;
    private final Integer count;

    Money(Integer description,Integer count) {
        this.count = count;
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getDescription() {
        return description;
    }
}
