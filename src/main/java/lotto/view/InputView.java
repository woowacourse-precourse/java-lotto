package lotto.view;

import static lotto.enums.PrintMsg.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(LINE_BREAK.getMessage() + INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(LINE_BREAK.getMessage() + INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
