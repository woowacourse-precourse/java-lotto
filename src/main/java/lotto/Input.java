package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchaseMoney() {
        String money = Console.readLine();
        return stringToIntMoney(money);
    }

    public static int stringToIntMoney(String money) {
        try {
            int input = Integer.parseInt(money);
            checkValidation(input);
            return input / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력하세요.");
        }
    }

    public static void checkValidation(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력하세요.");
        }
    }
}
