package lotto;

import lotto.console.ErrorMessage;

import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(List<Integer> numbers, String bonus) {
        type(bonus);
        int bonusNum = Integer.parseInt(bonus);
        range(bonusNum);
        repeat(numbers, bonusNum);
        this.bonusNumber = bonusNum;
    }

    private void range(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ErrorMessage.bonusLength.getValue());
        }
    }

    private void type(String bonus) {
        int eachChar = String.valueOf(bonus).charAt(0);
        if (!Character.isDigit(eachChar)) {
            throw new IllegalArgumentException(ErrorMessage.bonusType.getValue());
        }
    }

    private void repeat(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.bonusRepetition.getValue());
        }
    }
}
