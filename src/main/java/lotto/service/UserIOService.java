package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import static constants.Constants.*;

public class UserIOService {

    public int scanPayMoney() {
        System.out.println(START_MSG);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % LOTTO_PRICE == 0) return;
        throw new IllegalArgumentException(PAY_MONEY_ERROR);
    }

}
