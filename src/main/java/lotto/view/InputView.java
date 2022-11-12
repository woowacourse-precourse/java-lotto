package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.errorenum.Error;

public class InputView {
    private static final String MONEY_INPUT_REQUEST = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static int requestMoneyInput() {
        System.out.println(MONEY_INPUT_REQUEST);
        return readInputMoney(Console.readLine());
    }

    private static int readInputMoney(String input) {
        return toInt(input);
    }

    private static int toInt(String input) {
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Error.ACCEPT_ONLY_NUMBER.getCode());
        }
        return value;
    }
}
