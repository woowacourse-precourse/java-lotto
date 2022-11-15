package lotto.domain;

import lotto.app.Validation;

public class Money {
    private final int money;

    public Money(int money){
        Validation validation = new Validation();
        //validation.isThousandUnit(money);
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
