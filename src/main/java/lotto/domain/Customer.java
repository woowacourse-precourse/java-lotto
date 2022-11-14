package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.BaseValidation;

import static lotto.config.BaseValidation.*;

public class Customer {

    private static final int LOTTO_PRICE = 1000;
    private static final int REMAINDER = 0;

    private int money;
    private int hasLotto;

    public void payMoney() {

        try {
            this.money = Integer.parseInt(Console.readLine());
            if ((getMoney() % LOTTO_PRICE) != REMAINDER) {
                throw new IllegalArgumentException(INVALID_PAY_MONEY.getMessage());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }

    }

    public int getMoney() {
        return money;
    }

    public void buyLotto() {
        hasLotto = getMoney() / LOTTO_PRICE;
    }

    public int getHasLotto() {
        return hasLotto;
    }


}
