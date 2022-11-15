package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoInfo;

public class LottoValidator {

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
        if (numbers.size() != LottoInfo.SIZE.value()) {
            throw new IllegalArgumentException("[ERROR] Lotto 번호는 6개입니다.");
        }
    }

    private static void validateInRange(final List<Integer> numbers) throws IllegalArgumentException {
        numbers.forEach(number -> {
            if (number < LottoInfo.MIN_NUMBER.value() || number > LottoInfo.MAX_NUMBER.value()) {
                throw new IllegalArgumentException("[ERROR] Lotto 번호는 45 이하의 자연수입니다.");
            }
        });
    }

    private static void validateInRange(final int bonusNumber) {
        if (bonusNumber < LottoInfo.MIN_NUMBER.value() || bonusNumber > LottoInfo.MAX_NUMBER.value()) {
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
