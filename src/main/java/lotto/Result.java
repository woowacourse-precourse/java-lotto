package lotto;

import java.util.List;

public class Result {

    private final List<Integer> result;
    private final boolean isBonus;

    public Result(List<Integer> result) {
        this.isBonus = isBonusResult(result);
        this.result = splitBonusResult(result, isBonus);
    }
    public boolean getIsBonus() {
        return isBonus;
    }
    public int size() {
        return result.size();
    }
    private boolean isBonusResult(List<Integer> result) {
        if (result.contains(ReferenceValue.IS_LOTTO_BONUS_NUMBER)) {
            return true;
        }
        return false;
    }
    private List<Integer> splitBonusResult(List<Integer> result, boolean isBonus) {
        if (isBonus) {
            result.remove(ReferenceValue.IS_LOTTO_BONUS_NUMBER);
        }
        return result;
    }
}
