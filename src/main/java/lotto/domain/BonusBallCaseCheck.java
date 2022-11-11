package lotto.domain;

import java.util.List;

public class BonusBallCaseCheck {
    public int updateWinningNumber(List<Integer> bonusNumber, List<Integer> statistics) {
        int result = 0;
        for (int i = 0; i < bonusNumber.size(); i++) {
            if (bonusNumber.get(i) == 1) {
                result++;
            }
        }
        return result;
    }
}
