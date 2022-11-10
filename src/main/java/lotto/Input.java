package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public static String price() {
        System.out.println(ENTER_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
