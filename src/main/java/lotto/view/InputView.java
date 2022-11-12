package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String ERROR_NUMBER_ONLY = "[ERROR] 투입금액은 숫자만 입력가능합니다.";
    private static final String MESSAGE_MONEY_INPUT = "구입금액을 입력해주세요.";

    public static int getMoneyInput() {
        OutputView.printString(MESSAGE_MONEY_INPUT);
        String moneyInput = Console.readLine();
        if (!moneyInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
        return Integer.parseInt(moneyInput);
    }
}
