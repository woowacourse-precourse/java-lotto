package lotto.domain;

import lotto.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validLotto(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public MatchCount getMatchResult(LottoNumber lottoNumber) {
        int match = (int) lottoNumber.winningNumbers.stream()
                .filter(num -> numbers.contains(num))
                .count();
        int bonusMatch = 0;
        if (numbers.contains(lottoNumber.bonusNumber)) {
            bonusMatch++;
        }
        return new MatchCount(match, bonusMatch);
    }
}
