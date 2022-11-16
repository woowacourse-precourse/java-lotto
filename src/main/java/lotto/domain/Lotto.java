package lotto.domain;

import lotto.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validLotto(numbers);
        ArrayList<Integer> num = new ArrayList(numbers);
        Collections.sort(num);
        this.numbers = num;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public MatchCount getMatchResult(LottoNumber lottoNumber) {
        int winningCount = (int) lottoNumber.winningNumbers.stream()
                .filter(num -> numbers.contains(num))
                .count();
        int bonusCount = 0;
        if (numbers.contains(lottoNumber.bonusNumber)) {
            bonusCount++;
        }
        return new MatchCount(winningCount, bonusCount);
    }
}
