package lotto;

public class Seller {
    public void validateMoneyUnit(int money){
        if(money % 1000 != 0)
            throw new IllegalArgumentException();
    }
}
