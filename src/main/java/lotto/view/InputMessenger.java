package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessenger {

    private String receiveUserInput() {
        return Console.readLine();
    }

    public String receivePayment() {
        return receiveUserInput();
    }

    public String receiveWinningNumbers() {
        return receiveUserInput();
    }

    public String receiveBonusNumber() {
        return receiveUserInput();
    }
}
