package Service;

import java.util.List;

public class JudgeWinningOfLotto {

    public int compareMatchNumbers(List<Integer> RandomLotto, List<Integer> winninglotto) {
        int match = 0;
        for (int winningNumber : winninglotto) {
            if (RandomLotto.contains(winningNumber)) {
                match++;
            }
        }
        return match;
    }

    public boolean isContainBounsNumber(List<Integer> RandomLotto, int bounsNumber) {
        if (RandomLotto.contains(bounsNumber)) {
            return true;
        }
        return false;
    }

}
