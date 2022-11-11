package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNoDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBERS_LENGTH + "개입니다");
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다");
        }
    }
}
