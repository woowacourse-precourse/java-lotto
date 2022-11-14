package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_FOR_INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력해 주세요.";

    public static int getInputMoney() {
        try {
            System.out.println(MESSAGE_FOR_INPUT_PRICE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
        }
    }
}
