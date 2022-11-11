package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkRightSize(numbers);
        checkUniqueNumbers(numbers);
    }

    private void checkRightSize(List<Integer> numbers) {
        if (LOTTO_NUMBERS_SIZE != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (LOTTO_NUMBERS_SIZE != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
    }
}
