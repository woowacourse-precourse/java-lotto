package lotto.view;

import static lotto.domain.Error.NOT_NUMBER_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ENTER_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchaseMoney() {
        System.out.println(ENTER_PURCHASE_MONEY_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.toString());
        }
    }
}
