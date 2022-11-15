package lotto;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(List<Integer> numbers, int bonusNumber) {
        range(bonusNumber);
        type(bonusNumber);
        repeat(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void range(int bonus){
        if (String.valueOf(bonus).length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.bonusLength.getValue());
        }
    }
    private void type(int bonus) {
        int eachChar = String.valueOf(bonus).charAt(0);
        if (!Character.isDigit(eachChar)) {
            throw new IllegalArgumentException(ErrorMessage.bonusType.getValue());
        }
    }
    private void repeat(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)){
            throw new IllegalArgumentException(ErrorMessage.bonusRepetition.getValue());
        }
    }
}
