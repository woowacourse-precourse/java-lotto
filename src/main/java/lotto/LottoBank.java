package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBank {
    private int[] winningNumberMatchCount;
    private int winningMatchCount;
    private int totalProfit;

    public int[] calculateWinningMatchNumber(int lottoCount, List<List<Integer>> totalLotteries,
                                             List<Integer> winningNumbers) {
        winningNumberMatchCount = new int[lottoCount];
        for (List<Integer> lottery : totalLotteries) {
            winningMatchCount = compareWinningNumber(winningNumbers, lottery);
            int index = totalLotteries.indexOf(lottery);
            for (int i = 0; i < winningMatchCount; i++) {
                winningNumberMatchCount[index]++;
            }
        }
        return winningNumberMatchCount;
    }

    public int compareWinningNumber(List<Integer> winningNumbers, List<Integer> lottery) {
        winningMatchCount = 0;
        for (int lottoNumber : lottery) {
            if (winningNumbers.contains(lottoNumber)) {
                winningMatchCount++;
            }
        }
        return winningMatchCount;
    }

    public int[] compareBonusNumber(int lottoCount, int bonusNumber, List<List<Integer>> totalLotteries,
                                    List<Integer> winningNumbers) {
        winningNumberMatchCount = calculateWinningMatchNumber(lottoCount, totalLotteries, winningNumbers);
        for (int i = 0; i < winningNumberMatchCount.length; i++) {
            List<Integer> lottery = totalLotteries.get(i);
            if (winningNumberMatchCount[i] == 5 && lottery.contains(bonusNumber)) {
                winningNumberMatchCount[i] += 2;
            }
        }
        return winningNumberMatchCount;
    }

    public double calculateTotalMoney(int[] winningNumberMatchCount, int inputMoney) {
        List<Integer> winningNumberMatchCounts = Arrays.stream(winningNumberMatchCount)
                .boxed().collect(Collectors.toList());
        totalProfit = compareMatchCount(winningNumberMatchCounts);
        double profitRate = calculateProfitRate(inputMoney, totalProfit);
        return profitRate;
    }

    public int compareMatchCount(List<Integer> winningNumberMatchCounts) {
        for (int i = 0; i < winningNumberMatchCounts.size(); i++) {
            int rankMatchCount = winningNumberMatchCounts.get(i);
            totalProfit = calculateWinningMoney(rankMatchCount);
        }
        return totalProfit;
    }

    public double calculateProfitRate(int inputMoney, int totalProfit) {
        double profitRate = (double) totalProfit / inputMoney * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;
        return profitRate;
    }

    public int calculateWinningMoney(int rankMatchCount) {
        if (rankMatchCount == 3) {
            totalProfit += 5000;
        }
        if (rankMatchCount == 4) {
            totalProfit += 50000;
        }
        if (rankMatchCount == 5) {
            totalProfit += 1500000;
        }
        if (rankMatchCount == 6) {
            totalProfit += 2000000000;
        }
        if (rankMatchCount == 7) {
            totalProfit += 30000000;
        }
        return totalProfit;
    }
}