package lotto.domain;

import java.util.List;

public class BonusBallCaseCheck {
    public List<Integer> updateWinningNumber(List<Integer> number, List<Integer> bonusNumber) {
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i) == 5 && bonusNumber.get(i) == 1) {
                number.set(i, 7);
            }
        }
        return number;
    }
}
