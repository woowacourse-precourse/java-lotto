package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_LOTTO_SIZE_MESSAGE = "로또는 6개의 숫자로 구성됩니다.";
    private static final String LOTTO_HAS_DUPLICATE_MESSAGE = "로또는 중복되지 않은 숫자로 구성됩니다.";
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        checkSizeValidate(numbers);
        checkListDuplicate(numbers);
    }

    private static void checkSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private static void checkListDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != nonDuplicateNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
