package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.vlidation.InputBonusValidator;

public class BonusNumberController {
    private BonusNumberController() {
    }

    public static Integer inputBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER);
        String bonus = Console.readLine();
        InputBonusValidator.validate(bonus);
        return Integer.valueOf(bonus);
    }
}
