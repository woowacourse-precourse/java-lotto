package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    public final List<Integer> winningMatching;
    public final List<Boolean> bonusMatching;

    public Statistic(Winning winning, Purchase purchase) {
        this.winningMatching = initWinningMatching(winning.getWinningNumbers(), purchase.getLotteries());
        this.bonusMatching = initBonusMatching(winning.getBonusNumber(), purchase.getLotteries());
    }

    public List<Integer> initWinningMatching(List<Integer> winningNumber, List<Lotto> publishedLotteries) {
        List<Integer> winningMatching = new ArrayList<>();
        for (Lotto publishedLotto : publishedLotteries) {
            int count = countWinningNumberMatched(winningNumber, publishedLotto);
            winningMatching.add(count);
        }
        return winningMatching;
    }

    public List<Boolean> initBonusMatching(int bonusNumber, List<Lotto> publishedLotteries) {
        List<Boolean> bonusMatching = new ArrayList<>();
        for (Lotto publishedLotto : publishedLotteries) {
            boolean bonusNumberMatched = isBonusNumberMatched(bonusNumber, publishedLotto);
            bonusMatching.add(bonusNumberMatched);
        }

        return bonusMatching;
    }

    public int countWinningNumberMatched(List<Integer> winningNumber, Lotto publishedLottoNumber) {
        return (int)publishedLottoNumber.getNumbers().
                stream().filter(winningNumber::contains).count();
    }

    public boolean isBonusNumberMatched(int bonusNumber, Lotto publishedLottoNumbers) {
        return publishedLottoNumbers.getNumbers().contains(bonusNumber);
    }
}
