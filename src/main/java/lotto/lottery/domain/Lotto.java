package lotto.lottery.domain;

import java.util.List;
import lotto.lottery.validate.ValidateLotto;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidateLotto.validateSize(numbers);
        ValidateLotto.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
