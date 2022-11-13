package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.message.InputMessage;

public class InputView {

    public String inputPrice() {
        System.out.println(InputMessage.INPUT_PRICE);
        return Console.readLine();
    }

    public void printInputPriceAgain() {
        System.out.println(InputMessage.INVALID_INPUT_PRICE);
    }

    public String inputWinningNumber() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBER);
        return Console.readLine();
    }
}
