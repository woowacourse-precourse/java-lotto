package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.message.InputMessage;

public class InputView {

    public String inputPrice() {
        System.out.println(InputMessage.INPUT_PRICE);
        return Console.readLine();
    }
}
