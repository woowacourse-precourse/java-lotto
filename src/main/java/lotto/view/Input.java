package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        int purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }
}
