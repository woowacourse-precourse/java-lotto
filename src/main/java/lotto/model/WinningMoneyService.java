package lotto.model;

import lotto.util.Utils;

import java.util.List;

public class WinningMoneyService {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> lottoList;

    private Ranking ranking = new Ranking();

    public WinningMoneyService(WinningNumbers winningNumbers, List<Lotto> lottoList) {
        this.winningNumbers = winningNumbers;
        this.lottoList = lottoList;
    }

    public String calculateProfitRate(int inputMoney, int winningMoney) {
        double profitRate = ((double)winningMoney / inputMoney) * 100;

        return String.format("%.1f", profitRate);
    }

    public int calculateWinningMoney() {
        int winningMoney = 0;

        winningMoney += ranking.sumFifth();
        winningMoney += ranking.sumFourth();
        winningMoney += ranking.sumThird();
        winningMoney += ranking.sumSecond();
        winningMoney += ranking.sumFirst();

        return winningMoney;
    }


    public Ranking doAllRank() {
        for (Lotto numbers : lottoList) {
            ranking.doRank(doRank(numbers));
        }

        return ranking;
    }

    public int doRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int correctCount = sumContainCount(lottoNumbers, winningNumbers.getNumbers());
        boolean correctBonus = Utils.isContain(winningNumbers.getBonusNumber(), lottoNumbers);

        if (correctCount < 3) {
            return 0;
        }

        return calculateRank(correctCount, correctBonus);
    }

    public int sumContainCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int correctCount = 0;

        for (Integer number : lottoNumbers) {
            if (Utils.isContain(number, winningNumbers)) {
                correctCount++;
            }
        }

        return correctCount;
    }

    public int calculateRank(int correctCount, boolean correctBonus) {
        if (correctCount == 3) {
            return 5;
        }
        if (correctCount == 4) {
            return 4;
        }
        if (correctCount == 5 && !correctBonus) {
            return 3;
        }
        if ((correctCount == 5) && correctBonus) {
            return 2;
        }

        return 1;
    }

    public Ranking getRanking() {
        return ranking;
    }
}
