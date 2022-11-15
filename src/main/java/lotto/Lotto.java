package lotto;

import java.util.List;

import static lotto.Validate.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoSize(numbers);
        lottoDuplicate(numbers);
        for (Integer number : numbers) {
            inRangeLottoNumber(number);
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
