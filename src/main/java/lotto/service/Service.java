package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

public class Service {

    public static int getMoney() {
        String money = Console.readLine();
        Exception.verifyMoney(money);

        return Integer.parseInt(money);
    }
}
