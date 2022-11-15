package lotto.domain;

import lotto.utils.OutputView;

import java.util.List;

import static lotto.constant.Constants.*;

public class Game {

    Player player;
    WinningNumber winningNumber;

    public void startGame() {
        getWinningStatistics();
    }

    public Game() {
        player = new Player();
        winningNumber = new WinningNumber();
    }

    private void getWinningStatistics() {
        int[] result = countMatch(player.lottoNumbers, winningNumber.getLotto(), winningNumber.getBonusNumber());
        OutputView.printWinningStatistics(result);
        calcProfitPercent(result);
    }

    private void calcProfitPercent(int[] result) {
        List<Ranking> prizeSet = List.of(
                Ranking.FirstPlace,
                Ranking.SecondPlace,
                Ranking.ThirdPlace,
                Ranking.FourthPlace,
                Ranking.FifthPlace
        );
        double playerMoney = player.lottoCount * LOTTO_PRICE;
        double earnedMoney = 0;

        for (int i = 0; i < prizeSet.size(); i++) {
            earnedMoney += prizeSet.get(i).calcGetPrizeMoney(result[i + 1]);
        }
        double profit = earnedMoney / playerMoney * 100;
        OutputView.printProfitPercent(profit);
    }

    private int[] countMatch(List<Lotto> lottoNumbers, Lotto winningNumber, int bonusNumber) {
        return findNthPlace(lottoNumbers, winningNumber, bonusNumber);
    }

    private int[] findNthPlace(List<Lotto> lottoNumbers, Lotto winningNumber, int bonusNumber) {
        int result[] = new int[6];

        for (int i = 0; i < lottoNumbers.size(); i++) {
            int index = checkRank(lottoNumbers.get(i), winningNumber, bonusNumber);
            result[index]++;
        }
        return result;
    }

    private int checkRank(Lotto lotto, Lotto winningNumber, int bonusNumber) {
        int count = countNumberInLotto(lotto, winningNumber);

        if (count == Ranking.FifthPlace.HIT_COUNT_NUMBER)
            return 5;
        if (count == Ranking.FourthPlace.HIT_COUNT_NUMBER)
            return 4;
        if (count == Ranking.SecondPlace.HIT_COUNT_NUMBER && lotto.isContained(bonusNumber))
            return 2;
        if (count == Ranking.ThirdPlace.HIT_COUNT_NUMBER)
            return 3;
        if (count == Ranking.FirstPlace.HIT_COUNT_NUMBER)
            return 1;
        return 0;
    }

    private int countNumberInLotto(Lotto lotto, Lotto winningNumber) {
        int count = 0;
        List<Integer> winningLotto = winningNumber.getNumbers();
        for (int i = 0; i < LOTTO_COUNT; i++) {
            if (lotto.isContained(winningLotto.get(i))) {
                count++;
            }
        }
        return count;
    }

}
