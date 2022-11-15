package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoSettings.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
        if (numbers.stream()
                .allMatch(v -> v < LottoSettings.LOTTO_NUMBER_RANGE_START || v > LottoSettings.LOTTO_NUMBER_RANGE_END)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 1~45 사이의 숫자가 아닙니다.");
        }
        if (numbers.stream()
                .distinct()
                .count() != LottoSettings.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
