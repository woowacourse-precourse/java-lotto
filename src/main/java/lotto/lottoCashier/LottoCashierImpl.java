package lotto.lottoCashier;

import static lotto.constants.ExceptionMessage.*;
import static lotto.constants.LottoConstants.PRICE_OF_LOTTO;

public class LottoCashierImpl implements LottoCashier{

    @Override
    public void validateReceivedMoney(String inputMoney) {
        int moneyAsInt;
        try {
            moneyAsInt = Integer.parseInt(inputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        if(moneyAsInt <= 0) {
            throw new IllegalArgumentException(NOT_OVER_0);
        }
    }

    @Override
    public int calculateNumberOfLottos(int money) {
        if(money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE);
        }
        return money / PRICE_OF_LOTTO;
    }
}
