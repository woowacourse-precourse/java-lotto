package lotto.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.situation.LottoState;
import lotto.situation.LottoError;

public class LottoCompare {

    private int[] count;

    public LottoCompare(List<List<Integer>> quickPicks, List<Integer> lotto, int bonus) {
        validate(lotto, bonus);
        count = new int[LottoPrizes.values().length];
        for (List<Integer> quickPick : quickPicks) {
            checkingNumber(quickPick, lotto, bonus);
        }
    }
    private void validate(List<Integer> lotto, int bonus) {
        if (bonus < LottoState.START.number() || bonus > LottoState.END.number()) {
            LottoError.OUT_OF_BOUND.createError();
        }
        if (lotto.contains(bonus)) {
            LottoError.DUPLICATION.createError();
        }
    }
    private void checkingNumber(List<Integer> quickPick, List<Integer> lotto, int bonus) {
        ArrayList<Integer> matchingNumbers = new ArrayList<>(quickPick);
        matchingNumbers.retainAll(lotto);
        LottoPrizes prize = LottoPrizes.prizes(matchingNumbers.size(), quickPick.contains(bonus));
        count[prize.index()]++;
    }
    public Map<String, Integer> getPrizesMap() {
        Map<String, Integer> prizesMap = new HashMap<>();
        for (LottoPrizes lottoPrize : LottoPrizes.values()) {
            prizesMap.put(lottoPrize.name(), count[lottoPrize.index()]);
        }
        return prizesMap;
    }
}
