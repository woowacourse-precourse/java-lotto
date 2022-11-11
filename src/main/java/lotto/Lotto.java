package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public String checkWinningNums(List<Integer> winningNums, int bonusNum) {
        List<Integer> differentNums = numbers.stream().
            filter(number -> winningNums.stream().noneMatch(Predicate.isEqual(number)))
            .collect(Collectors.toList());

        if (differentNums.isEmpty()) {
            return "1등";
        } else if (differentNums.size() == 1 && differentNums.get(0).equals(bonusNum)) {
            return "2등";
        } else if (differentNums.size() == 1 && !differentNums.get(0).equals(bonusNum)) {
            return "3등";
        } else if (differentNums.size() == 2) {
            return "4등";
        } else if (differentNums.size() == 3) {
            return "5등";
        }
        return "당첨 X";
    }
}
