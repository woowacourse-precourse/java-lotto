package lotto.domain.ingame;

import java.util.List;

import static lotto.util.Message.LOTTO_DUPLICATE;
import static lotto.util.Message.LOTTO_INVALID_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_INVALID_SIZE);
        }
        if (numbers.size()!= numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE);
        }
    }

    public int compare(List<Integer> luckyNumbers) {
        return (int) numbers.stream()
                .filter(luckyNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
