package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.InputMessages.BUY_AMOUNT;

public class InputView {
    private InputView() {
    }

    public static String amount() {
        System.out.print(BUY_AMOUNT);
        return Console.readLine();
    }
}
