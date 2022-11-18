package lotto.domain;

import lotto.view.IOProcessor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatisticsBuilder {
    private final Map<String, Integer> winningInfo;

    public StatisticsBuilder() {
        winningInfo = new LinkedHashMap<>();
        setWinningInfoStorage();
    }

    public void build(List<Integer> winningNumber, int bonusNumber, List<Lotto> lottos) {
        setWinningInfoStorage();
        for (Lotto lotto : lottos) {
            String grade = WinningChecker.check(winningNumber, bonusNumber, lotto.getNumbers());
            if (!grade.equals("null")) {
                winningInfo.put(grade, winningInfo.get(grade) + 1);
            }
        }
    }

    public Map<String, Integer> getWinningInfo() {
        return this.winningInfo;
    }

    public void printWinningInfo() {
        IOProcessor.printWinningStatistics(winningInfo);
    }

    public void setWinningInfoStorage() {
        Policy.WinningAmount[] winnings = Policy.WinningAmount.values();
        for (Policy.WinningAmount winning : winnings) {
            winningInfo.put(winning.name(), 0);
        }
    }
}
