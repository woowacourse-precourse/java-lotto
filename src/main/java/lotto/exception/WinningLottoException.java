package lotto.exception;

import java.util.regex.Pattern;
import lotto.model.Lotto;

public class WinningLottoException {
    public static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    public static final String BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";

    public static void isValidInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }

    public static void isDuplicatedWithWinningNumbers(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    public static void isValidNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }
}
