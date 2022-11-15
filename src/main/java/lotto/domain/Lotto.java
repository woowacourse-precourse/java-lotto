package lotto.domain;

import lotto.validator.domain.LottoNumbersValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
    }
    
    public int countOfMatchingNumber(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isNumberContains)
                .count();
    }
    
    public boolean isNumberContains(final int lottoNumber) {
        return numbers.contains(lottoNumber);
    }
    
    public List<Integer> lottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
    
    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
