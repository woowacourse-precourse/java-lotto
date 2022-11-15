package lotto.domain;

import lotto.validation.InputValidation;
import lotto.view.InputView;

public class BonusNumber {

    int bonus;
    public BonusNumber(String userInput) {
        InputValidation.isNumber(userInput);
        this.bonus = Integer.parseInt(userInput);;
    }

    public int getBonus() {
        return bonus;
    }
}
