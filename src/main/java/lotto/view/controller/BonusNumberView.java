package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.vlidation.InputBonusValidator;

import static lotto.view.controller.ConsoleMessage.INPUT_BONUS_NUMBER;

public class BonusNumberView {
    private BonusNumberView() {
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String bonus = Console.readLine();
        InputBonusValidator.validate(bonus);
        return Integer.valueOf(bonus);
    }
}
