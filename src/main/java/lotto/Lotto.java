package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoMachine.LOTTO_NUMBER_SIZE;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }

    public static Lotto numberOf(List<Integer> numbers) {
        validate(numbers);

        return new Lotto(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            uniqueNumbers.add(number);
        }

        return uniqueNumbers.size() != numbers.size();
    }
}
