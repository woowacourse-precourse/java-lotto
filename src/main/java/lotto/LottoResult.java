package lotto;

import java.util.List;

public class LottoResult {

    private final List<Integer> result;
    private final boolean isBonus;

    public LottoResult(List<Integer> result) {
        this.isBonus = isBonusResult(result);
        this.result = splitBonusResult(result, isBonus);
    }
    public boolean getIsBonus() {
        return isBonus;
    }
    public List<Integer> getResult() {
        return result;
    }
    public int size() {
        return result.size();
    }
    private boolean isBonusResult(List<Integer> result) {
        if (result.contains(ReferenceValue.Lotto.IS_BONUS.getValue())) {
            return true;
        }
        return false;
    }
    private List<Integer> splitBonusResult(List<Integer> result, boolean isBonus) {
        if (isBonus) {
            result.remove(ReferenceValue.Lotto.IS_BONUS.getValue());
        }
        return result;
    }
}
