package lotto.aspect;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateInRange(numbers);
        validateUnique(numbers);
    }

    public static void validateBonusNumber(final List<Integer> numbers, final int bonusNumber) throws IllegalArgumentException {
        validateInRange(bonusNumber);
        validateUnique(numbers, bonusNumber);
    }

    private static void validateSize(final List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] Lotto 번호는 6개입니다.");
        }
    }

    private static void validateInRange(final List<Integer> numbers) throws IllegalArgumentException {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] Lotto 번호는 45 이하의 자연수입니다.");
            }
        });
    }

    private static void validateInRange(final int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] Lotto 번호는 45 이하의 자연수입니다.");
        }
    }

    private static void validateUnique(final List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> checker = new HashSet<>(numbers);

        if (checker.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateUnique(final List<Integer> numbers, final int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] Lotto의 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
