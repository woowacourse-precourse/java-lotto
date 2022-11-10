package lotto;

import lotto.exception.IllegalMoneyException;

public class Money {
    long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if(amount%1000!=0||amount<=0)
            throw new IllegalMoneyException();
    }
    public long getPayLottos(){
        return amount/1000;
    }
}
