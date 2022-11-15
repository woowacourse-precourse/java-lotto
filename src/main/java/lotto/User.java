package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Message.ERROR_INVALID_NUMBER;

public class User {
    public int inputMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INVALID_NUMBER.getMessage());
        }
        return money;
    }
}