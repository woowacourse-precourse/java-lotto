package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.OutputConstants.*;

public class InputView {

    public static String readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
