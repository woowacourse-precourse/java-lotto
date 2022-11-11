package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputMessage;

public class InputView {
    public String inputUserMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        return Console.readLine();
    }
}
