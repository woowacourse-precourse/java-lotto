package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
    }
    
    public int countOfSameNumber(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isExistSameLottoNumber)
                .count();
    }
    
    private boolean isExistSameLottoNumber(final Integer lottoNumberToCompare) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == lottoNumberToCompare);
    }
}
