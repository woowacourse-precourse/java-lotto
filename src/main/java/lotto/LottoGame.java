package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class LottoGame {
    private static final String INVALID_MONEY_TYPE_REGEX = "\\D";

    public String inputMoney() {
        String money = Console.readLine();
        validateMoneyType(money);
        return money;
    }

    private void validateMoneyType(String money) {
        if (Pattern.compile(INVALID_MONEY_TYPE_REGEX).matcher(money).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_TYPE.getMessage());
        }
    }
}
