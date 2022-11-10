package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class LottoGame {
    private static final String INVALID_MONEY_TYPE_REGEX = "\\D";
    private static final int UNIT_OF_MONEY = 1000;

    public String inputMoney() {
        String money = Console.readLine();
        validateMoneyType(money);
        validateUnitOf1000(money);
        return money;
    }

    private void validateMoneyType(String money) {
        if (Pattern.compile(INVALID_MONEY_TYPE_REGEX).matcher(money).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_TYPE.getMessage());
        }
    }

    private void validateUnitOf1000(String money) {
        if (Integer.parseInt(money) % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException();
        }
    }
}
