package lotto.Utils.Validator;

import static lotto.Utils.Constant.*;

import java.util.HashSet;
import java.util.Set;
import lotto.Utils.Util;

public class WinningLottoValidator {

    private static final String NOT_INTEGER_STATE = "로또 번호는 숫자로 입력되어야 합니다.";
    private static final String NOT_SIZE_STATE = "로또 번호는 6개 숫자입니다.";
    private static final String NOT_RANGE_STATE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NOT_OVERLAP_STATE = "로또 번호는 중복되지 않아야 합니다.";

    protected final String WinningLotto;

    public WinningLottoValidator(String WinningLotto) {
        this.WinningLotto = WinningLotto;
        isInteger();
        isValidLottoSize();
        isValidRange();
        isOverlap();
    }


    private void isInteger() {
        try {
            Util.getList(WinningLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }
    }

    private void isValidLottoSize() {
        if (Util.getList(WinningLotto).size() != NUMBERS_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR + NOT_SIZE_STATE);
        }
    }

    private void isValidRange() {
        if (!Util.checkRange(Util.getList(WinningLotto))) {
            throw new IllegalArgumentException(ERROR + NOT_RANGE_STATE);
        }
    }

    private void isOverlap() {
        Set set = new HashSet<>(Util.getList(WinningLotto));
        if (set.size() != 6) {
            throw new IllegalArgumentException(ERROR + NOT_OVERLAP_STATE);
        }
    }
}
