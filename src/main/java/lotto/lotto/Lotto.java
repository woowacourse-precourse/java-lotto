package lotto.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public void setBonusNumber(String input) {
        LottoValidator.validateLottoNumber(input);
        numbers.add(Integer.parseInt(input));
        LottoValidator.validateDuplicateNumbers(numbers);
    }
}
