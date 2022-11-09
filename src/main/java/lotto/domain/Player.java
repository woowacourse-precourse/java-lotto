package lotto.domain;

import java.util.List;

public class Player extends Lotto {
    private final int bonusNumber;

    public Player(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        duplicateValidateBonus(numbers,bonusNumber);
        rangeValidate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void duplicateValidateBonus(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void rangeValidate(List<Integer> numbers, int bonusNumber) {
        int maxNum = 45;
        int minNum = 1;

        if(bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException();

        for (int number:numbers) {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException();
        }
    }
}

