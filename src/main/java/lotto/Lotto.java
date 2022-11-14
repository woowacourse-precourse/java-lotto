package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchLotto(List<Integer> lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }


    public boolean contains(List<Integer> lottoWinningNumbers) {
        return numbers.contains(lottoWinningNumbers);
    }
}
