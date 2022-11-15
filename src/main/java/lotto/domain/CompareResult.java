package lotto.domain;

import lotto.Lotto;
import lotto.instance.matchType;

import java.util.List;

import static lotto.instance.matchType.*;

public class CompareResult {
    List<Integer> lottoNumbers;
    private int winningResult;
    private boolean bonusResult;
    private matchType type;

    public CompareResult(Lotto lotto, List<Integer> winning, int bonus) {
        this.lottoNumbers = lotto.getNumbers();
        compare(winning, bonus);
    }

    void matchWinning(List<Integer> winning) {
        int result = 0;
        for (int winNum : winning) {
            if (lottoNumbers.contains(winNum)) {
                result++;
            }
        }
        winningResult = result;
    }

    public void matchBonus(int bonus) {
        bonusResult = lottoNumbers.contains(bonus);
    }

    public void compare(List<Integer> winning, int bonus) {
        matchWinning(winning);
        matchBonus(bonus);
        decideType();
    }

    void decideType() {
        matchType type = NONE;
        if (winningResult == 3) {
            type = THREE;
        } else if (winningResult == 4) {
            type = FOUR;
        } else if (!bonusResult && (winningResult == 5)) {
            type = FIVE;
        } else if (bonusResult && (winningResult == 5)) {
            type = FIVE_BONUS;
        } else if (winningResult == 6) {
            type = SIX;
        }
        this.type = type;
    }

    public matchType getType() {
        return type;
    }
}
