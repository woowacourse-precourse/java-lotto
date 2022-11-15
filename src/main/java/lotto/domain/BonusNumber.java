package lotto.domain;

import lotto.validation.InputValidation;
import lotto.view.InputView;

public class BonusNumber {

    int bonus;
    public BonusNumber(String userInput) {
        try {
            InputValidation.isNumber(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.bonus = Integer.parseInt(userInput);;
    }

    public int getBonus() {
        return bonus;
    }
}
