package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (deduplicateNumbers(numbers) != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private long deduplicateNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수는 총 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
