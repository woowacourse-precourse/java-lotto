package lotto;

import type.LottoGrade;

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

    public Integer countNumbersIncluded(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public LottoGrade getLottoGrade(Integer numberOfMatches, Boolean containsBonusNumber) {
        if (numberOfMatches == 6) return LottoGrade.FIRST;
        if (numberOfMatches == 5 && containsBonusNumber) return LottoGrade.SECOND;
        if (numberOfMatches == 5) return LottoGrade.THIRD;
        if (numberOfMatches == 4) return LottoGrade.FOURTH;
        if (numberOfMatches == 3) return LottoGrade.FIFTH;
        return LottoGrade.NOTHING;
    }
}
