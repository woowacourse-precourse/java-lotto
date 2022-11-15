package lotto.domains;

import lotto.utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        Validator.validateLottoNumber(numbers);
        Validator.validateBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
