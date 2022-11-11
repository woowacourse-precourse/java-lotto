package lotto.domain;

import lotto.view.Output;

public class Money {

    private static final String UNIT_OF_MONEY_ERROR = "구매 금액은 1000원 단위로 입력 가능합니다.";
    private static final String MONEY_ONLY_NUMBER_MESSAGE = "구입 금액은 숫자만 입력 가능합니다.";
    private int money;

    public Money(int money) {
        this.money = validate(money);
    }

    public Money(String money) {
        this.money = validate(parseInt(money));
    }

    public int validate(int money) {
        if (money % 1000 == 0 && money != 0) {
            return money;
        }
        Output.printExceptionMessage(UNIT_OF_MONEY_ERROR);
        throw new IllegalArgumentException();
    }

    public int parseInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(MONEY_ONLY_NUMBER_MESSAGE);
            throw e;
        }
    }


    public boolean hasMoney() {
        return money != 0;
    }

    public void buyLotto(int price) {
        this.money -= price;
    }
}
