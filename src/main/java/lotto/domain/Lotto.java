package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import lotto.validate.ValidateLotto;

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
