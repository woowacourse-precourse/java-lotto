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
}
