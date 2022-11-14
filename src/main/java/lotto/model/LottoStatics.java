package lotto.model;

import java.util.Arrays;
import java.util.HashMap;

public class LottoStatics {
    private static final int DEFAULT_WINNING = 0;
    private static final int BONUS_SAME_COUNT = 5;

    private HashMap<Winning, Integer> staticsInfo;

    public LottoStatics() {
        initialMap();
    }

    private void initialMap() {
        HashMap<Winning, Integer> staticsInfo = new HashMap<>();
        for (Winning value : Winning.values()) {
            staticsInfo.put(value, DEFAULT_WINNING);
        }
        this.staticsInfo = staticsInfo;
    }

    public HashMap<Winning, Integer> getStaticsInfo() {
        return staticsInfo;
    }

    public int getTotalPrize() {
        int totalPrize = 0;
        for (Winning value : Winning.values()) {
            totalPrize += value.getPrize() * staticsInfo.get(value);
        }
        return totalPrize;
    }

    public void calculateStatics(Buyer buyer, LottoStore store) {
        for (Lotto lotto : buyer.getLottos()) {
            calculatePrize(lotto, store);
        }
    }

    public void calculatePrize(Lotto lotto, LottoStore store) {
        int sameCount = calculateSameCount(lotto, store);
        Arrays.stream(Winning.values())
                .filter(winning -> winning.getSameCount() == sameCount)
                .forEach(winning -> staticsInfo.put(winning, staticsInfo.get(winning) + 1));
        if (sameCount == BONUS_SAME_COUNT) {
            calculateBonus(lotto, store);
        }
    }

    private void calculateBonus(Lotto lotto, LottoStore store) {
        if (isBonusNumber(lotto, store)) {
            staticsInfo.put(Winning.THIRD, staticsInfo.get(Winning.THIRD) - 1);
            return;
        }
        staticsInfo.put(Winning.SECOND, staticsInfo.get(Winning.SECOND) - 1);
    }

    private int calculateSameCount(Lotto lotto, LottoStore store) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> store.getLottoNumbers().contains(number))
                .count();
    }

    private boolean isBonusNumber(Lotto lotto, LottoStore store) {
        return lotto.getNumbers().contains(store.getBonusNumber());
    }
}
