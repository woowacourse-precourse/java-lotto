package lotto;

public enum Money {
    THOUSAND(1000);

    private final int amount;

    Money(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
}





