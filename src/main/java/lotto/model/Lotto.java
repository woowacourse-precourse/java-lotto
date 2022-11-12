package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;
    private int sameNumbersCount;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateNumbers(numbers);
        this.numbers = numbers;
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
