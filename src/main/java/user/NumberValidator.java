package user;

import camp.nextstep.edu.missionutils.Console;
import ui.View;
import ui.ErrorConstant;

public class NumberValidator {

    public static int makeMoney() {
        View.promptSeedMoney();
        int money = inputToInteger();
        checkMoneyThousand(money);
        return money;
    }

    public static int makeLottoNumber() {
        View.promptBonusNumber();
        int lottoNumber = inputToInteger();
        checkLottoNumber(lottoNumber);
        return lottoNumber;
    }

    public static int inputToInteger() {
        String input = Console.readLine();
        checkInputNull(input);
        checkComponent(input);
        checkFirstNumberZero(input);
        return Integer.parseInt(input);
    }

    public static void checkInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorConstant.NOT_NULL_ERROR);
        }
    }

    // 01000 안되도록 수정할 것
    public static void checkComponent(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(ErrorConstant.NOT_NUMBER_COMPONENT);
            }
        }
    }

    public static void checkFirstNumberZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ErrorConstant.NOT_FIRST_NUMBER_ZERO);
        }
    }

    public static void checkMoneyThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorConstant.MONEY_NOT_DIVIDE_1000);
        }
    }

    public static void checkLottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NOT_NUMBER_RANGE);
        }
    }
}
