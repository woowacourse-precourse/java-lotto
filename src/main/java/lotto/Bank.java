package lotto;

import lotto.exception.MyIllegalArgumentException;

import java.util.HashMap;
import java.util.Map;

import static lotto.exception.ErrorCode.BONUS_NUMBER_ERROR;

public class Bank {
    private static final Map<Integer, String> score;
    static {
        score = new HashMap<>();
        score.put(0, null);
        score.put(1, null);
        score.put(2, null);
        score.put(3, "3개 일치 (5,000원)");
        score.put(4, "4개 일치 (50,000원)");
        score.put(5, "5개 일치 (1,500,000원)");
        score.put(6, "6개 일치 (2,000,000,000원)");
        score.put(7, "5개 일치, 보너스 볼 일치 (30,000,000원)");
    }
    private final Lotto winLotto;
    private final int bonusNumber;

    public Bank(Lotto winLotto, int bonusNumber) {
        validate(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winLotto, int bonusNumber) {
        if (winLotto.contains(bonusNumber)) {
            throw new MyIllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }
}
