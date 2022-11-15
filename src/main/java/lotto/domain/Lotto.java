package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.constant.Constants.*;
import static lotto.exception.Exception.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Arrays.sort(numbers.toArray());
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> sortedNumbers = toSortedList(numbers);
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> toSortedList(String numbers) {
        return Stream.of(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    public static Lotto generate() {
        return new Lotto(pickLottoNumbers());
    }

    private static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN,MAX,MAX_COUNT);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
