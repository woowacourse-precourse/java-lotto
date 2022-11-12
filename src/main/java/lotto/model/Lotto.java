package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;
    private int sameNumbers;
    private boolean sameBonusNumber;
    private Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validator.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void setSameNumbers(int sameNumbers) {
        this.sameNumbers = sameNumbers;
    }

    public void setSameBonusNumber(boolean sameBonusNumber) {
        this.sameBonusNumber = sameBonusNumber;
    }
}
