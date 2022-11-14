package lotto.domain;

import java.util.List;
import lotto.exception.domain.LottoNumberRangeException;
import lotto.exception.domain.LottoSizeException;
import lotto.exception.domain.LottoNumberDuplicateException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoSizeException(LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new LottoNumberDuplicateException();
        }
    }

    private void validateLottoNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new LottoNumberRangeException(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        }
    }

    public boolean isContainNumber(LottoBonusNumber lottoBonusNumber) {
        return this.numbers.stream()
                .anyMatch(lottoBonusNumber::equalNumber);
    }

    public int matchCount(Lotto matchLotto) {
        return Long.valueOf(this.numbers.stream()
                .filter(matchLotto.numbers::contains)
                .count()).intValue();
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return this.numbers.equals(lotto.numbers);
    }
}
