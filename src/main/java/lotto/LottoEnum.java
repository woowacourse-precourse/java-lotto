package lotto;

public enum LottoEnum {
    PRICE(1000),
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000)
    ;
    private final int value;

    LottoEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
