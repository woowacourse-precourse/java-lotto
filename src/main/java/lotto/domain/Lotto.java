package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean checkContainPrizeNumber(Integer prizeNumber) {
        return numbers.contains(prizeNumber);
    }
}
