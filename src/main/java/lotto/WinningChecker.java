package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Message;

public class WinningChecker {
    private final Map<Integer, Integer> winningChart;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningChecker(WinningNumber winningNumber) {
        winningChart = new HashMap<>();
        initWinningInfo(winningNumber);
        initWinningChart();
    }

    private void initWinningInfo(WinningNumber winningNumber) {
        winningNumbers = winningNumber.getWinningNumbers();
        bonusNumber = winningNumber.getBonusNumber();
    }

    private void initWinningChart() {
        winningChart.put(Message.RANKFIRST, 0);
        winningChart.put(Message.RANKSECOND, 0);
        winningChart.put(Message.RANKTHIRD, 0);
        winningChart.put(Message.RANKFOURTH, 0);
        winningChart.put(Message.RANKFIFTH, 0);
    }

    public void setWinningChart(List<Integer> lotto) {
        addWinningRecord(checkNumbers(lotto));
    }

    private int checkNumbers(List<Integer> lotto) {
        int sameNumberCount = 0;

        for (int num : winningNumbers) {
            if (lotto.contains(num)) {
                sameNumberCount++;
            }
        }
        if (getBonus(sameNumberCount, lotto)) {
            sameNumberCount = Message.RANKSECOND;
        }
        return sameNumberCount;
    }

    private boolean getBonus(int sameNumberCount, List<Integer> lotto) {
        return sameNumberCount == Message.RANKTHIRD && lotto.contains(bonusNumber);
    }

    private void addWinningRecord(int sameNumberCount) {
        winningChart.put(sameNumberCount, winningChart.get(sameNumberCount) + 1);
    }

    public Map<Integer, Integer> getWinningChart() {
        return winningChart;
    }
}
