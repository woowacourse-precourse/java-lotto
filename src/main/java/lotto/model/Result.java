package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.toIntExact;
import static lotto.utils.Constant.LOTTO_END;
import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.LOTTO_START;

public class Result {
    public static final String ENTER_RIGHT_SIZE_NUMBER = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final String ENTER_UNIQUE_NUMBER = "[ERROR] 중복된 숫자를 입력하실 수 없습니다.";
    public static final String ENTER_UNIQUE_BONUS_NUMBER = "[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.";
    public static final String INPUT_RIGHT_RANGE_NUMBER = "[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.";
    public static final int BONUS_NUMBER_MATCH = 1;
    public static final int BONUS_NUMBER_NOT_MATCH = 0;

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
        validateRange(winningNumbers);
        validateSize(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
    }

    private static void validateRange(List<Integer> numbers) {
        if (isRightRange(numbers)) {
            throw new IllegalArgumentException(INPUT_RIGHT_RANGE_NUMBER);
        }
    }

    private static boolean isRightRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(Result::validateRange);
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
        isRightRange(bonusNumber);
        isUniqueNumber(winningNumbers, bonusNumber);
    }

    private static void isUniqueNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (isDuplicated(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ENTER_UNIQUE_BONUS_NUMBER);
        }
    }

    private static boolean isDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private static void isRightRange(int bonusNumber) {
        if (validateRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_RIGHT_RANGE_NUMBER);
        }
    }

    private static boolean validateRange(Integer number) {
        return number < LOTTO_START || LOTTO_END < number;
    }

    public Prize compare(Lotto lotto) {
        int winningMatches = checkWithWinningNumbers(lotto);

        int bonusMatches = checkWithBonusNumber(lotto);

        return Prize.judge(winningMatches, bonusMatches);
    }

    private int checkWithBonusNumber(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return BONUS_NUMBER_MATCH;
        }
        return BONUS_NUMBER_NOT_MATCH;
    }

    private int checkWithWinningNumbers(Lotto lotto) {
        return toIntExact(winningNumbers.stream()
                .filter(lotto::contains)
                .count());
    }

    public Map<Prize, Long> compareLottos(Lottos lottos) {
        return lottos.compareResult(this);
    }
}
