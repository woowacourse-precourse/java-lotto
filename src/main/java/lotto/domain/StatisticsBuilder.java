package lotto.domain;

import lotto.view.IOProcessor;

import java.util.ArrayList;
import java.util.List;

public class StatisticsBuilder {

    private final List<Integer> winningInfo; // 당첨정보 저장

    public StatisticsBuilder() {
        winningInfo = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            winningInfo.add(0);
        }
    }

    public void build(List<Integer> winningNumber, int bonusNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int grade = WinningChecker.check(winningNumber, bonusNumber, lotto.getNumbers());
            winningInfo.set(grade, winningInfo.get(grade) + 1);
        }
    }

    public List<Integer> getWinningInfo() {
        return this.winningInfo;
    }

    public void printWinningInfo() {
        IOProcessor.printWinningStatistics(winningInfo);
    }
}
