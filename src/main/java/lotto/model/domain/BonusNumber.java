package lotto.model.domain;

import java.util.List;
import java.util.regex.Pattern;
import lotto.utils.Utils;

public class BonusNumber {

    private static final String BONUS_NUMBER_REGEX = "^[0-9]*";
    private static final String BONUS_NUMBER_IS_NOT_NUMBER = "보너스 번호는 숫자 이어야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE = "보너스 번호는 1이상 45 이어야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;

    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningNumber) {
        this.bonusNumber = validateBonusNumber(bonusNumber, winningNumber);
    }

    private int validateBonusNumber(String bonusNumber, List<Integer> winningNumber) {
        bonusNumber = Utils.deleteAllString(bonusNumber);
        if (!Pattern.matches(BONUS_NUMBER_REGEX, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMBER);
        }
        return validateBonusNumber(Integer.parseInt(bonusNumber), winningNumber);
    }

    private int validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        if (isInvalidLottoNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
        if (isDuplicatedWithWinningNumber(bonusNumber, winningNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
        return bonusNumber;
    }

    private boolean isInvalidLottoNumberRange(int num) {
        return num < LOTTO_NUM_MIN || num > LOTTO_NUM_MAX;
    }

    private boolean isDuplicatedWithWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        return winningNumber.contains(bonusNumber);
    }

    boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
