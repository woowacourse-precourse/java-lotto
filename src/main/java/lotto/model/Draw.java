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

    private Rank winningNumSize(Lotto tryLotto) {
        return null;
    }

    private boolean isBonusExist(int bonusNum) {
        return false;
    }

    private void validateBonusNumRange(int bonusNum) {

    }



}
