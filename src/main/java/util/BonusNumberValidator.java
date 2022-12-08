package util;

import domain.lotto.Lotto;

public class BonusNumberValidator {

    private static final String ERROR_TYPE = "[ERROR] 보너스 번호는 숫자로만 입력해야합니다.";
    private static final String ERROR_RANGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해야 합니다.";

    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;

    Lotto winningLotto;
    String bonusNumber;

    public BonusNumberValidator(String bonusNumber, Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void validate() {
        validateType();
        validateRange();
        validateDuplicate();
    }

    private void validateDuplicate() {
        for (int order = 0; order < winningLotto.size(); order++) {
            compareBonusNumberWithEachLottoNumber(order);
        }
    }

    private void compareBonusNumberWithEachLottoNumber(int order) {
        if (winningLotto.get(order) == Integer.parseInt(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void validateRange() {
        if (Integer.parseInt(bonusNumber) > MAX_NUM || Integer.parseInt(bonusNumber) < MIN_NUM) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void validateType() {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }
}
