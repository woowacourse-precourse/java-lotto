package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> overlap = new HashSet<>();
        for (int number : numbers) {
            numberOverlapCheck(overlap, number);
            numberMaxMinCheck(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }//추가

    private void numberMaxMinCheck(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException();
        }
    }
    private void numberOverlapCheck(Set<Integer> overlap, int number) {
        if (overlap.contains(number)) {
            throw new IllegalArgumentException();
        }
        overlap.add(number);
    }
    // TODO: 추가 기능 구현
}
