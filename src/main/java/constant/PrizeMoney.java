package constant;

public enum PrizeMoney {
    FIRST_MONEY(2000000000), SECOND_MONEY(30000000), THIRD_MONEY(1500000), FOURTH_MONEY(50000), FIFTH_MONEY(5000);


    private final int value;
    PrizeMoney(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
