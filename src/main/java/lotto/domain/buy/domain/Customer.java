package lotto.domain.buy.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ErrorMessage.ERROR_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.ERROR_ONLY_THOUSANDS;
import static lotto.constant.Integer.LOTTO_PRICE;

public class Customer {

    public final int count;
    final int price;

    public Customer() {
        String tmp = Console.readLine();
        try {
            price = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        validate(price);
        this.count = price / LOTTO_PRICE;
    }

    private void validate(int price) {
        if (price % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ERROR_ONLY_THOUSANDS);
    }
}
