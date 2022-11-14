package lotto;

import java.util.List;

public class LottoBank {
    private int[] winningNumberMatchCount;
    private int winningMatchCount;

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
}