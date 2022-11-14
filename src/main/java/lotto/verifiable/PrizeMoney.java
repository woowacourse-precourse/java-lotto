package lotto.verifiable;

public enum PrizeMoney {
    FIVE(5000L),
    FOUR(50000L),
    THIRD(1500000L),
    SECOND(30000000L),
    FIRST(2000000000L);


    private final Long value;
    private PrizeMoney(Long i){
        this.value = i;
    }

    public Long getValue() {
        return value;
    }
}