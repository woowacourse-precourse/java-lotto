package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;
    private int sameNumbersCount;
    private int bonusNumber;
    private Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validator.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validator.validateNumbers(numbers);
        this.numbers = numbers;
        validator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void compareLotto(List<Integer> inputNumbers) {
        int count = 0;
        for (int lottoNumber : numbers) {
            if (inputNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        this.sameNumbersCount = count;
    }
}
