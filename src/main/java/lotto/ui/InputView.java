package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";

    public static int inputBuyingAmount() {
        System.out.println(REQUEST_MONEY);
        String buyingAmount = Console.readLine();
        InputViewValidation.validateIsInteger(buyingAmount);
        InputViewValidation.validateIs1000(buyingAmount);

        return Integer.parseInt(buyingAmount);
    }

}
