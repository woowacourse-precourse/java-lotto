package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final String NUMBER_SEPARATOR = ", ";
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 중복된 숫자로 구성될 수 없습니다.");
        }
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public int getContainValue(Integer number) {
        if (isContain(number)) {
            return 1;
        }
        return 0;
    }

    public int getMatchedCount(Lotto compareLotto) {
        int matchedCount = 0;
        for (Integer number : numbers) {
            matchedCount += compareLotto.getContainValue(number);
        }
        return matchedCount;
    }

    @Override
    public String toString() {
        List<Integer> numbersForSort = new ArrayList(numbers);
        Collections.sort(numbersForSort);
        List<String> stringNumbers = numbersForSort.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(NUMBER_SEPARATOR, stringNumbers);
    }
}