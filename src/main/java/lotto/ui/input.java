package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import static lotto.messages.UI_MSG.*;

public class input {

    static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE.getMsg());
        return Console.readLine();
    }
}
