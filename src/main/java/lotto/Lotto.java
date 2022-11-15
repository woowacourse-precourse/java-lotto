package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        bonusNumber = BonusNumber();
        System.out.println(numbers);
        System.out.println(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Integer BonusNumber() {
        bonusNumber = Randoms.pickNumberInRange(1, 45);
        while (numbers.contains(bonusNumber)) {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        }
        return bonusNumber;
    }
}
