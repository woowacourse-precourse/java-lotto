package lotto;

import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import static lotto.LottoConfiguration.*;

public class Receipt {
    private int money;
    private int amount;

    public Receipt(String input) {
        validate(input);
        money = Integer.parseInt(input);
        amount = money / 1000;
    }

    private void validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
            if (money > 0 && money % PRICE == 0) {
                return;
            }
        } catch (NumberFormatException ignored) {
        }
        throw new MyIllegalArgumentException(ErrorCode.MONEY_ERROR);
    }
}
