package data;

public enum NumericData {
    NUMBER_AMOUNT(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_PRICE(1000),
    FIFTH_PRIZE(5000),
    FOURTH_PRIZE(50000),
    THIRD_PRIZE(1500000),
    SECOND_PRIZE(30000000),
    FIRST_PRIZE(2000000000);

    private final int number;

    NumericData(int number){
        this.number = number;
    }

    public int getValue(){
        return number;
    }
}
