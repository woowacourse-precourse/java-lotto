package lotto.domain;

import java.util.List;
import lotto.domain.validation.LottoNumbersValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumbersValidation.validate(numbers);
    }

    public int getRank(Lotto userNumbers, Integer bonusNumber) {
        int numberCount = getCorrectNumberCountInNumbers(userNumbers.numbers);
        int bonusCount = getCorrectBonusCount(bonusNumber);
        return LottoUtil.checkRank(numberCount, bonusCount);
    }

    public int getCorrectNumberCountInNumbers(List<Integer> userNumbers) {
        return userNumbers.stream().filter(numbers::contains).toArray().length;
    }

    public int getCorrectBonusCount(Integer bonusNumber) {
        return numbers.stream().filter(bonusNumber::equals).toArray().length;
    }

    public boolean containBonusNumber(Integer bonus) {
        return numbers.contains(bonus);
    }
}
