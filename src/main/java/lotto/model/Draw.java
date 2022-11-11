package lotto.model;

import lotto.enums.Rank;

import java.util.List;
import java.util.Map;

public class Draw {
    private Lotto winningLotto;
    private int bonusNum;

    public Draw(Lotto winningLotto, int bonusNum){
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Map<Rank,Integer> getWinningStats(List<Lotto> lottoPaper) {
        return null;
    }

    private int winningNumSize(Lotto tryLotto) {
        int winningCount = 0;
        Lotto winningLotto = this.winningLotto;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> tryLottoNumbers = tryLotto.getNumbers();

        for (Integer tryNumber : tryLottoNumbers) {
            if (winningLottoNumbers.contains(tryNumber)) {
                winningCount++;
            }
        }

        return winningCount;
    }

    private boolean isBonusExist(int bonusNum) {
        return false;
    }

    private void validateBonusNumRange(int bonusNum) {

    }



}
