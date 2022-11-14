package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        includeDuplicates(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_SIZE);
        ArrayList<Integer> randomNumbers = new ArrayList<>(randoms);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new ErrorException(Error.INVALID_LOTTO_SIZE.toString());
        }
    }

    public void includeDuplicates(List<Integer> numbers) {
        List<Integer> deduplicated = numbers.stream()
                .distinct().collect(Collectors.toList());
        if (deduplicated.size() != LOTTO_SIZE) {
            throw new ErrorException(Error.INCLUDE_DUPLICATE_VALUE.toString());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
