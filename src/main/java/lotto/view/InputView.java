package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestMoney() {
        OutputView.printRequestMoney();
        return Console.readLine();
    }

    public static String requestWinningNumber() {
        OutputView.printRequestWinningNumber();
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        OutputView.printRequestBonusNumber();
        return Console.readLine();
    }
}
