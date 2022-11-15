package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.vlidation.InputBonusValidator;

public class BonusNumberView {
    private BonusNumberView() {
    }

    public static Integer inputBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER);
        String bonus = Console.readLine();
        InputBonusValidator.validate(bonus);
        return Integer.valueOf(bonus);
    }
}
