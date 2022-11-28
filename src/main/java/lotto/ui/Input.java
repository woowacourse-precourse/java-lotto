package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import static lotto.messages.UI_MSG.*;

public class Input {

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE.getMsg());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMsg());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMsg());
        return Console.readLine();
    }
}
