package lotto.domain.lotto_numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto implements LottoNumbers {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public int matchNumberCounts(List<Integer> winningNumbers) {
        return (int) numbers.stream()  // 포함된 애들만 셈
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> numbers() {
        List<Integer> copied = new ArrayList<>(Collections.unmodifiableList(numbers));
        Collections.sort(copied);
        return copied;
    }
}
