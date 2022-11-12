package lotto;

import java.util.*;
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
        Set<Integer> deleteDuplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != deleteDuplicatedNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
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
