package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countCorrectNums(List<List<Integer>> inputNumbers, int countNum, int index) {
        int count = countNum;
        for (Integer number: numbers) {
            if (inputNumbers.get(index).contains(number)) {
                count++;
            }
        }
        return count;
    }

}
