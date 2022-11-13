package lotto.validator;

import java.util.List;

import static lotto.util.Const.*;

public class LottoValidator {

    public static void check(List<Integer> lotto) {
        checkSize(lotto);
        checkNumberRange(lotto);
        checkUnique(lotto);
    }

    public static void checkSize(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 크기는 6이여야 합니다.");
        }
    }

    public static void checkUnique(List<Integer> lotto) throws IllegalArgumentException {
        if (getUniqueCount(lotto) != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 숫자는 중복을 허락하지 않습니다.");
        }
    }

    private static long getUniqueCount(List<Integer> lotto) {
        return lotto.stream().distinct().count();
    }

    public static void checkNumberRange(List<Integer> lotto) throws IllegalArgumentException {
        lotto.stream()
                .filter(LottoValidator::isNumberWrongRange)
                .forEach(number -> {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 가능합니다.");
        });
    }

    private static boolean isNumberWrongRange(int number) {
        return (number < START_NUMBER || number > END_NUMBER);
    }

    public static void checkBonusNumber(List<Integer> lotto, int bonusNumber) throws IllegalArgumentException {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 로또 정답 숫자와 중복될 수 없습니다.");
        }
    }
}
