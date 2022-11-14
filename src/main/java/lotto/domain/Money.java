package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ErrorMessage;

import java.util.Arrays;

public class Money {

    private final int money;

    public Money(String money) {
        checkNumber(money);
        checkFirstNumberIsNotZero(money);
        checkThousandMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void checkNumber(String input) {
        String[] split = input.split("");

        boolean result = Arrays.stream(split).allMatch((alphbet) -> alphbet.charAt(0) >= '0' && alphbet.charAt(0) <= '9');
        if (!result)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
    }

    private void checkFirstNumberIsNotZero(String input) {
        String[] split = input.split("");

        if (split.length > 1 && Integer.parseInt(split[0]) == 0)
            throw new IllegalArgumentException(ErrorMessage.FIRST_NUMBER_IS_NOT_ZERO);
    }

    private void checkThousandMoney(String input) {
        int price = Integer.parseInt(input);

        if (price % Constant.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MUST_THOUSAND_PRICE);
    }

    public int getNumberOfPurchase() {
        return money / Constant.LOTTO_PRICE;
    }
}
