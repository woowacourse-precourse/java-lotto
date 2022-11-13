package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.toIntExact;
import static lotto.utils.Constant.LOTTO_SIZE;

public class Result {
    public static final String ENTER_RIGHT_SIZE_NUMBER = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final String ENTER_UNIQUE_NUMBER = "[ERROR] 중복된 숫자를 입력하실 수 없습니다.";
    public static final String ENTER_UNIQUE_BONUS_NUMBER = "[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.";

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    private Result() {
    }

    private Result(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Result of(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        return new Result(winningNumbers, bonusNumber);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (isDifferentSize(numbers)) {
            throw new IllegalArgumentException(ENTER_RIGHT_SIZE_NUMBER);
        }
    }

    private static boolean isDifferentSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (hasDuplicateNumbers(uniqueNumbers)) {
            throw new IllegalArgumentException(ENTER_UNIQUE_NUMBER);
        }
    }

    private static boolean hasDuplicateNumbers(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ENTER_UNIQUE_BONUS_NUMBER);
        }
    }

    public Prize compare(Lotto lotto) {
        int winningMatches = checkWithWinningNumbers(lotto);

        int bonusMatches = checkWithBonusNumber(lotto);

        return Prize.judge(winningMatches, bonusMatches);
    }

    private int checkWithBonusNumber(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private int checkWithWinningNumbers(Lotto lotto) {
        return toIntExact(winningNumbers.stream()
                .filter(lotto::contains)
                .count());
    }
}
