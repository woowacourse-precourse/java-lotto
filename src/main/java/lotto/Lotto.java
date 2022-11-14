package lotto;

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
        if (numbers.size() != Constants.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.isNotMatch(Constants.LOTTO));
        }
        for (int number : numbers) {
            if (number < Constants.MIN || number > Constants.MAX) {
                throw new IllegalArgumentException(ErrorMessages.isOutOfBounds(Constants.LOTTO));
            }
        }
        Set<Integer> removeRepeatedNumbers = new HashSet<>(numbers);
        if (removeRepeatedNumbers.size() != Constants.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.isRepeated(Constants.LOTTO));
        }
    }

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.MIN, Constants.MAX, Constants.MAX_COUNT
        );
        return new Lotto(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Rank match(WinningNumbers winningNumbers) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers.winningNumbers::contains)
                .count();
        boolean matchBonusNumber = numbers.contains(winningNumbers.bonusNumber);
        return Rank.of(matchCount, matchBonusNumber);
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
