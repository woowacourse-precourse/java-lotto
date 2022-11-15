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
        winningChart.put(Message.RANKFIRST, Message.ZEROINIT);
        winningChart.put(Message.RANKSECOND, Message.ZEROINIT);
        winningChart.put(Message.RANKTHIRD, Message.ZEROINIT);
        winningChart.put(Message.RANKFOURTH, Message.ZEROINIT);
        winningChart.put(Message.RANKFIFTH, Message.ZEROINIT);
    }

    public void setWinningChart(List<Integer> lotto) {
        addWinningRecord(checkNumbers(lotto));
    }

    private int checkNumbers(List<Integer> lotto) {
        int sameNumberCount = Message.ZEROINIT;

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
        if (winLotto(sameNumberCount))
            winningChart.put(sameNumberCount, winningChart.get(sameNumberCount) + Message.ONETIME);
    }

    private boolean winLotto(int sameNumberCount) {
        return sameNumberCount >= Message.WINLOTTO;
    }

    public Map<Integer, Integer> getWinningChart() {
        return winningChart;
    }
}
