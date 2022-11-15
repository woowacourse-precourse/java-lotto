package lotto.model.resources;

import java.util.List;

import lotto.ExceptionHandle;

public class BonusLotto {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private final int bonusNum;

    private BonusLotto(String bonusNum, List<Integer> lotto) {
        this.bonusNum = validateBonus(bonusNum, lotto);
    }

    public static BonusLotto of(String bonusNum, List<Integer> lotto) {
        return new BonusLotto(bonusNum, lotto);
    }

    private int validateBonus(String bonus, List<Integer> lotto) {
        int tmpBonus = makeBonusNumber(bonus);
        validateDuplicate(tmpBonus, lotto);
        return tmpBonus;
    }

    private void validateDuplicate(long bonus, List<Integer> lotto) {
        long count = lotto.stream()
                .filter(i -> i == bonus)
                .count();
        try {
            if (count != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionHandle("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다. - BonusLotto");
        }
    }

    private void validateNumber(long bonus) {
        try {
            if (bonus < LOTTO_MIN_NUM || LOTTO_MAX_NUM < bonus) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionHandle("[ERROR] 보너스 범위가 적절하지 않습니다. - BonusLotto");
        }
    }

    private int makeBonusNumber(String bonus) {
        long realBonus;
        try {
            realBonus = Long.parseLong(bonus);
        } catch (NumberFormatException e) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException ex) {
                throw new ExceptionHandle("[ERROR] 보너스 금액을 숫자로 입력해주세요. - BonusLotto");
            }
        }
        validateNumber(realBonus);
        return (int) realBonus;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
