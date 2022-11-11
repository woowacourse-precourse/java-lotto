package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 올바르지 않은 로또 개수입니다.";
    private static final String DUPLICATED_NUMBER_MESSAGE = "[ERROR] 중복된 로또 번호입니다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = to(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> value() {
        return numbers.stream()
                .map(LottoNumber::value)
                .collect(toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
        }
    }

    private List<LottoNumber> to(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(toList());
    }
}
