package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class Validator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_RANGE = String.format("[ERROR] 로또 번호의 숫자 범위는 %d~%d까지입니다.",
            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    private static final String ERROR_SIZE = String.format("[ERROR] 당첨 번호는 %d개 입니다.", LOTTO_SIZE);
    private static final String ERROR_DUPLICATED = String.format("[ERROR] 당첨 번호는 %d개 입니다.", LOTTO_SIZE);
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
        if (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)) {
            System.out.println(ERROR_RANGE);
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_SIZE);
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> noDuplicated = new HashSet<>(numbers);
        if (noDuplicated.size() != numbers.size()) {
            System.out.println(ERROR_DUPLICATED);
            throw new IllegalArgumentException(ERROR_DUPLICATED);
        }
    }

    private static void validateBonusDuplication(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            System.out.println(ERROR_BONUS_DUPLICATED);
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATED);
        }
    }
}
