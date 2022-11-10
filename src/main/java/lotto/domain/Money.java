package lotto.domain;


import lotto.view.Output;

public class Money {

    private static final Integer MONEY_UNIT = 1000;
    private static final String MONEY_UNIT_ERROR_MESSAGE = "금액은 1000원 단위이어야 합니다.";

    private final Integer money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    public Integer getTicket() {
        return money / MONEY_UNIT;
    }

    public void validate(Integer money) {
        if (money % MONEY_UNIT > 0) {
            Output.printErrorMessage(MONEY_UNIT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
