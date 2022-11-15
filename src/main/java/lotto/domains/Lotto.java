package lotto.domains;

import lotto.utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Integer bonusNumber;

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
        try {
            return bonusNumber;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 초기화 되지 않았습니다.");
        }
    }
}
