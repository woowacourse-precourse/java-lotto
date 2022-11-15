package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            LottoService.validateMatchNumbers(numbers);
        } catch (IllegalArgumentException exception) {
            String oldMessage = exception.getMessage();
            throw new IllegalArgumentException(oldMessage.replace("당첨", "로또"));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
