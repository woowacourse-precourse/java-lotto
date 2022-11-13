package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validator;

public class UserInterface {
    private static final String INPUT_MONEY_ANNOUNCEMENT = "구입금액을 입력해 주세요.";

    public static String getInputMoney() {
        System.out.println(INPUT_MONEY_ANNOUNCEMENT);
        String inputMoneyRaw = Console.readLine();
        Validator.checkInputMoney(inputMoneyRaw);
        return inputMoneyRaw;
    }
}
