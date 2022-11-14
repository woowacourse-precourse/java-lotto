package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;
import lotto.validation.InputValidation;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static UserLotto inputUserMoney() {
        printRequestMoneyInputMessage();
        String input = Console.readLine();

        InputValidation.isValidInput(input);
        return new UserLotto(Integer.parseInt(input));
    }

    private static void printRequestMoneyInputMessage() {
        System.out.println(REQUEST_MONEY_MESSAGE);
    }
}
