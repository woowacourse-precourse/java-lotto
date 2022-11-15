package lotto.option;

public enum IntegerOption {
    MIN(1),
    MAX(45),
    COUNT(6),
    FIFTH_PRICE(5000),
    FOURTH_PRICE(50000),
    THIRD_PRICE(1500000),
    SECOND_PRICE(30000000),
    FIRST_PRICE(2000000000),
    ZERO(0),
    FIFTH_MATCH(3),
    FOURTH_MATCH(4),
    THIRD_MATCH(5),
    SECOND_MATCH(5),
    FIRST_MATCH(6),
    BASE_MONEY(1000);

    public Integer option;
    IntegerOption(Integer option){
        this.option = option;
    }
}
