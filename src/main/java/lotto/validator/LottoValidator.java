package lotto.validator;

import java.util.List;

import static lotto.util.Const.*;

public class LottoValidator {

    public static void check(List<Integer> lotto) {
        checkSize(lotto);
        checkNumberRange(lotto);
        checkUnique(lotto);
    }

    private static void checkSize(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 크기는 6이여야 합니다.");
        }
    }

    private static void checkUnique(List<Integer> lotto) throws IllegalArgumentException {
        if (hasDuplicateNumber(lotto)) {
            throw new IllegalArgumentException("로또 숫자는 중복을 허락하지 않습니다.");
        }
    }

    private static boolean hasDuplicateNumber(List<Integer> lotto) {
        return lotto.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }

    private static void checkNumberRange(List<Integer> lotto) throws IllegalArgumentException {
        lotto.stream()
                .filter(LottoValidator::isNumberWrongRange)
                .forEach(number -> {
                    throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 가능합니다.");
                });
    }

    private static boolean isNumberWrongRange(int number) {
        return (number < START_NUMBER || number > END_NUMBER);
    }

    public static void checkBonusNumber(List<Integer> lotto, int bonusNumber) {
        if (isNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }

        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

}
