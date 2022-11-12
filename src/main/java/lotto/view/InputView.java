package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Messages;

public class InputView {
    public static String inputMoney() {
        System.out.printf(Messages.INPUT_MONEY.get());
        return Console.readLine();
    }

    public static String inputWinLotto() {
        return "";
    }
}
