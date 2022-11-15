package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static constant.Config.MAX_NUMBER;
import static constant.Config.MIN_NUMBER;
import static constant.Config.NUMBER_COUNT;

public class Lotto {
    private static final String SIZE_ERROR = String.format("로또 번호는 %d개의 숫자여야 합니다.", NUMBER_COUNT);
    private static final String DUPLICATE_ERROR = "로또 번호는 중복되지 않아야 합니다.";
    private static final String RANGE_ERROR = String.format("로또 번호는 %d~%d 범위여야 합니다.", MIN_NUMBER, MAX_NUMBER);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);

        List<Integer> sortNumbers = getSortNumbers(numbers);
        this.numbers = List.copyOf(sortNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private List<Integer> getSortNumbers(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);

        return sortNumbers;
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        int matchCount = getMatchCount(winningNumbers);
        boolean containsBonusBall = isContainsBonusBall(bonusNumber);

        return setWinningResult(matchCount, containsBonusBall);
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isContainsBonusBall(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private WinningResult setWinningResult(int matchCount, boolean containsBonusBall) {
        WinningResult winningResult = new WinningResult();

        Optional<Win> ranking = Win.getRanking(matchCount, containsBonusBall);

        ranking.ifPresent(winningResult::putWinningResult);
        return winningResult;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
