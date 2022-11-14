package lotto;

import java.util.List;

public class Compare {
    private List<Integer> winningLotto;
    private int bonusNumber;

    public void setWinningLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Rank compareLotto(Lotto lotto) {
        int count = 0;

        for(int num : winningLotto) {
            if(lotto.isContainNumber(num)) {
                count++;
            }
        }

        Rank rank = Rank.rankByContainCount(count);

        if(rank == Rank.RANK_3) {
            if(lotto.isContainBonusNumber(bonusNumber)) {
                return  Rank.RANK_2;
            }
        }

        return rank;
    }
}
