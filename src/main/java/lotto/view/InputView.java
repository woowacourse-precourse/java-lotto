package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMoney() {
        System.out.println(ViewMessage.INPUT_MONEY);
        return Console.readLine();
    }
}
