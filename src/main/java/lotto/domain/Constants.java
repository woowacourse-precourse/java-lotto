package lotto.domain;

public enum Constants {
    PRICE(1000),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    NUMBER_TO_DRAW(6);

    private final Integer value;
    Constants(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }

}
