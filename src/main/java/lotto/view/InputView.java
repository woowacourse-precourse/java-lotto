package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.MessagePrinter;

public class InputView {
    public Integer askPrice() {
        MessagePrinter.printAskPriceMessage();
        String InputValue = Console.readLine();
        return Integer.valueOf(InputValue);
    }
}
