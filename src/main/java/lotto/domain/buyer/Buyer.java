package lotto.domain.buyer;

import lotto.constant.ErrorMessage;

public class Buyer {
    private final int money;

    public Buyer(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void validate(int money) throws IllegalArgumentException {
        if(money%1000!=0 || money<0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
    }

    public static Buyer of(int money) {
        return new Buyer(money);
    }
}
