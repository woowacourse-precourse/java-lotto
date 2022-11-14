package lotto.domain.match;

import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;

import java.util.List;

import static lotto.domain.lotto.Lotto.MAX_NUMBER;
import static lotto.domain.lotto.Lotto.MIN_NUMBER;

public class WinningNumbers {

    private final List<Integer> standardNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> standardNumbers, int bonusNumber) {
        validateStandardNumbers(standardNumbers);
        validateBonusNumber(bonusNumber);
        validateDuplicateAllNumbers(standardNumbers, bonusNumber);

        this.standardNumbers = standardNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateStandardNumbers(List<Integer> numbers) {
        validateStandardNumbersSize(numbers);
        validateDuplicateStandardNumbers(numbers);
        validateStandardNumbersRange(numbers);
    }

    private static void validateStandardNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicateStandardNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복되면 안됩니다.");
        }
    }

    private void validateStandardNumbersRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(
                number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!(MIN_NUMBER <= bonusNumber && bonusNumber <= MAX_NUMBER)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateAllNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복되면 안됩니다.");
        }
    }

    private int getMatchedNumberCount(Lotto lotto) {
        return (int) lotto.value().stream()
                .filter(standardNumbers::contains)
                .count();
    }

    private boolean isMatchedBonus(Lotto lotto) {
        return lotto.value().stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private Reward match(Lotto lotto) {
        return Reward.find(getMatchedNumberCount(lotto), isMatchedBonus(lotto));
    }

    public MatchResults matchAll(List<Lotto> lottos) {
        return new MatchResults(lottos.stream()
                .map(this::match)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningNumbers)) {
            return false;
        }

        WinningNumbers that = (WinningNumbers) o;

        if (bonusNumber != that.bonusNumber) {
            return false;
        }
        return Objects.equals(standardNumbers, that.standardNumbers);
    }

    @Override
    public int hashCode() {
        int result = standardNumbers != null ? standardNumbers.hashCode() : 0;
        result = 31 * result + bonusNumber;
        return result;
    }
}
