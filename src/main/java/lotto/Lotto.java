package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        Validator validator = new Validator();
        this.numbers = validator.validDateWinningNumbers(numbers);
    }

    public List<Integer> getWinningLotto() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
