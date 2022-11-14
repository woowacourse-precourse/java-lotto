package lotto.util;

import java.util.List;

import static lotto.model.GameNumber.LOTTO_SIZE;

public class MatchUtil {
    private int cnt, length = LOTTO_SIZE.getNumber();

    public int matchWinningNumber(List<Integer> lotto, List<Integer> userNum) {
        cnt = 0;
        for (int i = 0; i < length; i++) {
            if (lotto.contains(userNum.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public int matchBonusNumber(List<Integer> lotto, int bonusNum) {
        cnt = 0;
        for (int i = 0; i < length; i++) {
            if (lotto.get(i).equals(bonusNum)) {
                cnt++;
            }
        }
        return cnt;
    }
}
