package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import static lotto.domain.Preset.FIVE_EQUALS;
import static lotto.domain.Preset.SECOND_WINNING;
import static lotto.domain.WinningType.getWinningType;
import static lotto.view.OutputView.printEachWinningResult;

public class WinningResult {
    private final Map<WinningType, Integer> results;

    public WinningResult(WinningLotto winningLotto, Lottos purchasedLottos) {
        this.results = new EnumMap<>(WinningType.class);
        updateResults(winningLotto, purchasedLottos);
    }

    public void updateResults(WinningLotto winningLotto, Lottos purchasedLottos) {
        for (Lotto lotto : purchasedLottos.getLottos()) {
            int equalNumber = winningLotto.countEqualNumber(lotto);

            if (equalNumber == SECOND_WINNING) {
                findTypeAndIncreaseResult(FIVE_EQUALS, true);
                continue;
            }
            findTypeAndIncreaseResult(equalNumber, false);
        }
    }

    public void findTypeAndIncreaseResult(int equalNumber, boolean withBonus) {
        WinningType type = getWinningType(equalNumber, withBonus);
        this.increaseOneByKey(type);
    }

    public void increaseOneByKey(WinningType type) {
        if (results.containsKey(type)) {
            results.put(type, results.get(type) + 1);
            return;
        }
        results.put(type, 1);
    }

    public double calculateEarning(int inputMoney) {
        double earning = 0;

        Iterator<WinningType> winningTypeIterator = getWinningTypeIterator();
        while (winningTypeIterator.hasNext()) {

            WinningType type = winningTypeIterator.next();
            earning += (double) type.getWinnings() * (double) results.get(type);
        }
        return earning / inputMoney;
    }

    public void print() {

        Iterator<WinningType> winningTypeIterator = getWinningTypeIterator();
        while (winningTypeIterator.hasNext()) {

            WinningType type = winningTypeIterator.next();
            results.putIfAbsent(type, 0);

            printEachWinningResult(type, results);
        }
    }

    public static Iterator<WinningType> getWinningTypeIterator() {
        return Arrays.stream(WinningType.values()).iterator();
    }
}
