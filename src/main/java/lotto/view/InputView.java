package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputConstants;

public class InputView {

    public static String readPurchaseAmount() {
        System.out.println(OutputConstants.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println();
        System.out.println(OutputConstants.INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println();
        System.out.println(OutputConstants.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
