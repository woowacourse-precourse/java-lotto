package lotto.domain.vo;

import lotto.enums.ErrorMessage;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int money;

    public BuyLotto(String money) {
        this. money = moneyValidate(money);
    }

    public int getMoney() {
        return money;
    }

    private int moneyUnitValidate(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_UNIT_MONEY.getErrorMessage());
        }
        return money;
    }

    private int moneyValidate(String money) {
        try {
            return moneyUnitValidate(Integer.parseInt(money));
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
        }
    }

    public int lottoTicketsCount() {
        return money / LOTTO_PRICE;
    }
}
