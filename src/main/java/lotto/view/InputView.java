package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Messages;

public class InputView {
    public static String inputMoney() {
        System.out.println(Messages.INPUT_MONEY_MESSAGE.get());
        return Console.readLine();
    }
}
