package lotto.domain;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import static lotto.controller.LottoController.getWinningTypeIterator;
import static lotto.view.OutputView.printEachWinningResult;

public class WinningResult {

    private final Map<WinningType, Integer> results;

    public WinningResult() {
        this.results = new EnumMap<>(WinningType.class);
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
        earning /= inputMoney;

        return earning;
    }

    public void print() {

        Iterator<WinningType> winningTypeIterator = getWinningTypeIterator();

        while (winningTypeIterator.hasNext()) {

            WinningType type = winningTypeIterator.next();
            results.putIfAbsent(type, 0);

            printEachWinningResult(type, results);
        }
    }

}
