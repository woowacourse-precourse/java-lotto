package lotto.Utils.Validator;

import static lotto.Utils.Constant.*;

import java.util.List;
import lotto.Utils.Util;

public class BonusValidator {

    private static final String NOT_INTEGER_STATE = "보너스 번호는 숫자로 입력되어야 합니다.";
    private static final String NOT_RANGE_STATE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NOT_OVERLAP_STATE = "보너스 번호는 중복되지 않아야 합니다.";

    protected final List<Integer> WinningLotto;
    protected final String BonusLotto;

    public BonusValidator(List<Integer> WinningLotto, String BonusLotto) {
        this.WinningLotto = WinningLotto;
        this.BonusLotto = BonusLotto;
        isInteger();
        isValidRange();
        isOverlap(this.WinningLotto);
    }

    ;

    private void isInteger() {
        try {
            Util.getInt(BonusLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }
    }

    private void isValidRange() {
        if (Util.getInt(BonusLotto) > 45 || Util.getInt(BonusLotto) < 1) {
            throw new IllegalArgumentException(ERROR + NOT_RANGE_STATE);
        }
    }

    private void isOverlap(List<Integer> WinningLotto) {
        if (WinningLotto.contains(Util.getInt(BonusLotto))) {
            throw new IllegalArgumentException(ERROR + NOT_OVERLAP_STATE);
        }
    }
}
