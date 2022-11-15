package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRedundantNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRedundantNumber(List<Integer> numbers) {
        List<Integer> removeRedundantNumber = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (removeRedundantNumber.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static List<Integer> createRandomLottoNumber() {
        List<Integer> createdNumbersFromRandoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ArrayList<Integer> createdRandomNumbers = new ArrayList<>(createdNumbersFromRandoms);
        Collections.sort(createdRandomNumbers);

        return createdRandomNumbers;
    }
}
