package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMoney() {
        System.out.println(ViewMessage.INPUT_MONEY.getMessage());
        return Console.readLine();
    }

    public String inputNumbers() {
        System.out.println(ViewMessage.INPUT_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
