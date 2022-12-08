package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoRank;
import lotto.lotto.Lottos;
import lotto.lotto.WinningLotto;

import java.util.List;

public class Result {
    public void compare(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            int result = checkCount(lotto, winningLotto);
            whatRank(result, lotto, winningLotto);
        }
    }

    private int checkCount(Lotto lotto, WinningLotto winningLotto) {
        int count = 0;
        List winningLottoNumbers = winningLotto.getLotto().getNumbers();
        for (int number : lotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void whatRank(int count, Lotto lotto, WinningLotto winningLotto) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchedCount() == 5 && count == 5) {
                checkBonus(lotto, winningLotto);
                return;
            }
            if (count == rank.getMatchedCount()) {
                rank.plus();
            }
        }
    }

    private void checkBonus(Lotto lotto, WinningLotto winningLotto) {
        if (lotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            LottoRank.SECOND.plus();
            return;
        }
        LottoRank.THIRD.plus();
    }

    public double revenue(int money) {
        int total = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            int benefit = lottoRank.getResult() * lottoRank.getMoney();
            total += benefit;
        }
        return calculateRevenue(total, money);
    }

    private double calculateRevenue(int total, int money) {
        double result = ((double)total / money) * 100;
        return result;
    }
}