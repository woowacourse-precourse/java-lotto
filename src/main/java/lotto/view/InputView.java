package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getLottoPurchaseAmount() {
        OutputView.printLottoPurchaseAmount();
        int input = Integer.parseInt(Console.readLine());
        return input;
    }
}
