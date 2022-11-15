package lotto.model;

import java.math.BigDecimal;
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

    public BigDecimal getTotalPrize() {
        BigDecimal totalPrize = new BigDecimal("0");
        for (Winning value : Winning.values()) {
            BigDecimal count = new BigDecimal(String.valueOf(staticsInfo.get(value)));
            BigDecimal tmpPrize = new BigDecimal(String.valueOf(value.getPrize()));

            BigDecimal multiple = tmpPrize.multiply(count);
            totalPrize = totalPrize.add(multiple);
        }
        return totalPrize;
    }

    public void calculateStatics(Buyer buyer, LottoStore store) {
        for (Lotto lotto : buyer.getLottos()) {
            updateStaticsInfo(lotto, store);
        }
    }

    public void updateStaticsInfo(Lotto lotto, LottoStore store) {
        int sameCount = calculateSameCount(lotto, store);
        boolean bonus = isBonus(lotto, store, sameCount);

        Winning prize = Winning.findWinning(sameCount, bonus);
        staticsInfo.put(prize, staticsInfo.get(prize) + 1);
    }

    private int calculateSameCount(Lotto lotto, LottoStore store) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> store.getLottoNumbers().contains(number))
                .count();
    }

    private boolean isBonus(Lotto lotto, LottoStore store, int sameCount) {
        if (sameCount == BONUS_SAME_COUNT) {
            return lotto.getNumbers().contains(store.getBonusNumber());
        }
        return false;
    }
}
