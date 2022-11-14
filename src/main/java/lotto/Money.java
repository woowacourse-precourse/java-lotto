package lotto;

public class Money {
    private final int money;
    public Money(int money){
        this.money = money;
    }

    int numberOfPurchase(){
        return money / 1_000;
    }
}
