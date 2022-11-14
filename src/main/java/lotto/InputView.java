package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_AMOUNT_MSG = "구입금액을 입력해 주세요.";

    public static String getPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MSG);
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }
}
