package lotto.domain.lotto_numbers;

import java.util.List;

public class Lotto implements LottoNumbers {
    
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }
}
