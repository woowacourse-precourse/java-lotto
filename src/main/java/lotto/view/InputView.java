package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputPurchasePrice() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }
}
