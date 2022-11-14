package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInterface {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String readPurchaseAmount() {
        String purchaseAmount;

        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        purchaseAmount = readLine();
        return (purchaseAmount);
    }
}
