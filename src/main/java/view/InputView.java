package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String receivePurchaseAmount() {
        OutputView.requestPurchaseAmount();
        return Console.readLine();
    }
}
