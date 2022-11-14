package lotto.option;

public enum Option {
    MIN(1),
    MAX(45),
    COUNT(6),
    FIFTH_PRICE(5000),
    FOURTH_PRICE(50000),
    THIRD_PRICE(1500000),
    SECOND_PRICE(30000000),
    FIRST_PRICE(2000000000);

    public Integer option;
    Option(Integer option){
        this.option = option;
    }
}
