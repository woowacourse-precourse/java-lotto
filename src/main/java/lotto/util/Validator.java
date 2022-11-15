package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class Validator {
    private static final String ERROR_RANGE = String.format("[ERROR] 로또 번호의 숫자 범위는 %d~%d까지입니다.",
            Setting.MIN_LOTTO_NUMBER, Setting.MAX_LOTTO_NUMBER);
    private static final String ERROR_SIZE = String.format("[ERROR] 당첨 번호는 %d개 입니다.", Setting.LOTTO_SIZE);
    private static final String ERROR_DUPLICATED = String.format("[ERROR] 당첨 번호는 %d개 입니다.", Setting.LOTTO_SIZE);
    private static final String ERROR_BONUS_DUPLICATED = "[ERROR] 당첨 번호와 다른 값을 입력하세요.";

    public static void validateLotto(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    public static void validateBonusNumber(Lotto lotto, int bonusNumber) {
        validateLottoRange(bonusNumber);
        validateBonusDuplication(lotto, bonusNumber);
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoRange(number);
        }
    }

    private static void validateLottoRange(int number) {
        if (!(Setting.MIN_LOTTO_NUMBER <= number && number <= Setting.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Setting.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> noDuplicated = new HashSet<>(numbers);
        if (noDuplicated.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED);
        }
    }

    private static void validateBonusDuplication(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATED);
        }
    }
}
