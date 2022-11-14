package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.ViewMessage.*;

public class InputView {
    public String inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
        return Console.readLine();
    }

    public String inputNumbers() {
        System.out.println(INPUT_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
