package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int checkNumbers(List<Integer> userLottoNumbers) {
        userLottoNumbers.removeAll(numbers);
        int correctNumbers = numbers.size() - userLottoNumbers.size();
        return correctNumbers;
    }


}
