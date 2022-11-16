package lotto;

import java.util.List;

public class JudgmentBonusNumberGenerator {
    public static int JudgmentBonusNumber(List<List<Integer>> correctNumberList, int bonusNumber, int returnNumber, int i) {
        if (correctNumberList.get(i).contains(bonusNumber)) {
            returnNumber += 1;
        }
        return returnNumber;
    }
}
