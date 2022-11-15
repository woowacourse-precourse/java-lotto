package lotto;

public enum Money {
    THOUSAND(1000),
    FIVE_THOUSAND(5000),
    FIFTY_THOUSAND(50000),
    ONE_MILLION_HALF(1500000),
    THIRTY_MILLION(30000000),
    TWO_BILLION(2000000000);

    private final int amount;

    Money(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
}





