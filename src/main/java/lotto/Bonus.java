package lotto;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(List<Integer> numbers, int bonusNumber) {
        range(bonusNumber);
        //type(bonusNumber);
        //repeat(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void range(int bonus){
        if (String.valueOf(bonus).length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.bonusLength.getValue());
        }
    }
}
