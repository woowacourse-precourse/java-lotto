package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;
import lotto.validation.InputValidation;

import static lotto.constant.MessageConstant.MESSAGE_INPUT_MONEY;

public class InputView {
    public static UserLotto inputUserMoney() {
        printRequestMoneyInputMessage();
        String input = Console.readLine();

        InputValidation.isValidInput(input);
        return new UserLotto(Integer.parseInt(input));
    }

    private static void printRequestMoneyInputMessage() {
        System.out.println(MESSAGE_INPUT_MONEY);
    }
}
