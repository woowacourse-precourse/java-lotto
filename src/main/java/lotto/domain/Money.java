package lotto.domain;

import lotto.status.NumberStatus;

public class Money {
    private Integer money;
    private Integer theNumberOfLotto;

    public Money(Integer money) {
        this.money = money;
        this.theNumberOfLotto = money / NumberStatus.BASE_PRICE_OF_LOTTO.getNumber();
    }


    public Integer getTheNumberOfLotto() {
        return theNumberOfLotto;
    }

    public Integer getMoney() {
        return money;
    }


}
