package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);

        return Console.readLine();
    }
}