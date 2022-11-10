package lotto.domain;

import java.util.List;

import static lotto.LottoExceptions.createLottoException;

public class Lotto {
    public static final int NUMBER_COUNT = 6;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws Exception {
        validateSize(numbers);
        validateDistinct(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) throws Exception {
        if (numbers.size() != NUMBER_COUNT) {
            throw createLottoException("로또번호는 6개여야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) throws Exception {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw createLottoException("로또번호는 중복되면 안됩니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) throws Exception {
        if (!numbers.stream().allMatch(
                number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw createLottoException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
