package lotto;

import java.util.List;

public class Compare {
    private List<Integer> winningLotto;
    private int bonusNumber;

    public Rank compareLotto(Lotto lotto){
        int count = 0;
        for(int number : winningLotto) {
            if(lotto.isContainNumber(number)){
                count+=1;
            }
        }
        Rank rank = Rank.rankByContainCount(count);

        if (rank == Rank.RANK_3) {
            if(lotto.isContainBonusNumber(bonusNumber)) {
                return Rank.RANK_2;
            }
        }
        return rank;
    }
}
