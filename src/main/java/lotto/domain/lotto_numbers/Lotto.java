package lotto.domain.lotto_numbers;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto implements LottoNumbers {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public int matchNumberCounts(List<Integer> winningNumbers) {
        // 정렬이 되어있으니까 순차적으로 비교하면 됨.
        return (int) IntStream.range(0, 6)
                .filter(i -> numbers.get(i).equals(winningNumbers.get(i)))
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
