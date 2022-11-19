package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBank {
    private int[] winningNumberCount;
    private int winningCount;
    private int totalProfit;

    public int[] calculateWinningCount(int lottoCount, List<List<Integer>> totalLotteries,
                                       List<Integer> winningNumbers) {
        winningNumberCount = new int[lottoCount];
        for (List<Integer> lottery : totalLotteries) {
            winningCount = compareWinningNumber(winningNumbers, lottery);
            int index = totalLotteries.indexOf(lottery);
            for (int i = 0; i < winningCount; i++) {
                winningNumberCount[index]++;
            }
        }
        return winningNumberCount;
    }

    public int compareWinningNumber(List<Integer> winningNumbers, List<Integer> lottery) {
        winningCount = 0;
        for (int lottoNumber : lottery) {
            if (winningNumbers.contains(lottoNumber)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    public int[] compareBonusNumber(int lottoCount, int bonusNumber, List<List<Integer>> totalLotteries,
                                    List<Integer> winningNumbers) {
        winningNumberCount = calculateWinningCount(lottoCount, totalLotteries, winningNumbers);
        for (int i = 0; i < winningNumberCount.length; i++) {
            List<Integer> lottery = totalLotteries.get(i);
            if (winningNumberCount[i] == 5 && lottery.contains(bonusNumber)) {
                winningNumberCount[i] += 2;
            }
        }
        return winningNumberCount;
    }

    public double calculateProfit(int[] winningNumberCount, int inputMoney) {
        List<Integer> winningNumberCountList = Arrays.stream(winningNumberCount)
                .boxed().collect(Collectors.toList());
        totalProfit = calculateTotalProfit(winningNumberCountList);
        double profitRate = calculateProfitRate(inputMoney, totalProfit);
        return profitRate;
    }

    public int calculateTotalProfit(List<Integer> winningNumberCount) {
        for (int i = 0; i < winningNumberCount.size(); i++) {
            int winningCountByRank = winningNumberCount.get(i);
            totalProfit = calculateWinningMoney(winningCountByRank);
        }
        return totalProfit;
    }

    public double calculateProfitRate(int inputMoney, int totalProfit) {
        double profitRate = (double) totalProfit / inputMoney * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;
        return profitRate;
    }

    public int calculateWinningMoney(int winningCountByRank) {
        if (winningCountByRank == 3) {
            totalProfit += 5000;
        }
        if (winningCountByRank == 4) {
            totalProfit += 50000;
        }
        if (winningCountByRank == 6) {
            totalProfit += 2000000000;
        }
        bonusMoneyOfFiftyPlace(winningCountByRank);
        return totalProfit;
    }

    public void bonusMoneyOfFiftyPlace(int winningCountByRank) {
        if (winningCountByRank == 5) {
            totalProfit += 1500000;
        }
        if (winningCountByRank == 7) {
            totalProfit += 30000000;
        }
    }
}