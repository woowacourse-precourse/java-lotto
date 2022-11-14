package ui;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private static final int PRICE_UNIT = 1000;
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int enterPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String price = Console.readLine();
        System.out.println();

        return Integer.parseInt(price) / PRICE_UNIT;
    }
}
