package lotto.domain;

import java.util.List;
import lotto.exception.domain.LottoSizeException;
import lotto.exception.domain.LottoNumberDuplicateException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
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

    public boolean isContainNumber(LottoNumber lottoNumber) {
        return this.numbers.stream()
                .anyMatch(lottoNumber::equalNumber);
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
