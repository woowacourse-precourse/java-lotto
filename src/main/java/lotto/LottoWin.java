package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {

    private int[] count;

    public LottoWin(List<List<Integer>> quickPicks, List<Integer> lotto, int bonus) {
        validate(lotto, bonus);
        count = new int[LottoPrizes.values().length];
        for (List<Integer> quickPick : quickPicks) {
            matchingNumber(quickPick, lotto, bonus);
        }
    }
    private void validate(List<Integer> lotto, int bonus) {
        if (bonus < LottoState.START.number() || bonus > LottoState.END.number()) {
            throw new IllegalArgumentException();
        }
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
    private void matchingNumber(List<Integer> quickPick, List<Integer> lotto, int bonus) {
        ArrayList<Integer> matchingNumbers = new ArrayList<>(quickPick);
        matchingNumbers.retainAll(lotto);
        LottoPrizes prize = LottoPrizes.prizes(matchingNumbers.size(), quickPick.contains(bonus));
        count[prize.index()]++;
    }
    public Map<String, Integer> getPrizesMap() {
        Map<String, Integer> prizesMap = new HashMap<>();
        for (LottoPrizes lottoPrize : LottoPrizes.values()) {
            prizesMap.put(lottoPrize.key(), count[lottoPrize.index()]);
        }
        return prizesMap;
    }
}
