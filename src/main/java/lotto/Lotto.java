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

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public String checkWinningNums(List<Integer> winningNums, int bonusNum) {
        List<Integer> differentNums = numbers.stream().
            filter(number -> winningNums.stream().noneMatch(Predicate.isEqual(number)))
            .collect(Collectors.toList());

        if (differentNums.isEmpty()) {
            return RankValue.FST_RANK.getRank();
        } else if (differentNums.size() == 1 && differentNums.get(0).equals(bonusNum)) {
            return RankValue.SCD_RANK.getRank();
        } else if (differentNums.size() == 1 && !differentNums.get(0).equals(bonusNum)) {
            return RankValue.THD_RANK.getRank();
        } else if (differentNums.size() == 2) {
            return RankValue.FOUR_RANK.getRank();
        } else if (differentNums.size() == 3) {
            return RankValue.FIVE_RANK.getRank();
        }
        return RankValue.NOTHING.getRank();
    }
}
