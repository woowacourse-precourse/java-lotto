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
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력하실 수 없습니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers, int bonusNumber) {
        int maxNum = 45;
        int minNum = 1;

        if(bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[ERROR] 범위를 초과한 번호는 입력하실 수 없습니다.");

        for (int number:numbers) {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 범위를 초과한 번호는 입력하실 수 없습니다.");
        }
    }
}

