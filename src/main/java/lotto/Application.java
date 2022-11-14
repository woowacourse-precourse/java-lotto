package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

public class Application {
    private static final int LOTTO_BUY_CURRENCY = 1000;

    public static void main(String[] args) {
        try {
            int amount = askAmount();
        } catch (MyIllegalArgumentException e) {
            e.printErrorMessage();
        }
    }

    public static int askAmount() {
        try {
            int money = Integer.parseInt(Console.readLine()) / 1000;
            if (isValidMoney(money)) {
                return money;
            }
        } catch (NumberFormatException ignored) {
        }
        throw new MyIllegalArgumentException(ErrorCode.MONEY_ERROR);
    }

    /**
     * 예외 처리를 위한 편의 기능
     */
    public static boolean isValidMoney(int money) {
        return money % LOTTO_BUY_CURRENCY == 0;
    }
}
