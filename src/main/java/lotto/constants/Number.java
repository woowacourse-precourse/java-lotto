package lotto.constants;

public enum Number {
    RANGE_START(1),
    RANGE_END(45),
    LENGTH(6),
    PRICE(1000)
    ;

    private final int number;

    Number(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
