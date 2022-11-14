package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constants.*;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MSG);
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }
}
