package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Rank> ranks = new ArrayList<>();

    public void setRanksItem(Lotto winningLotto, Lotto lotto, boolean hasBonusNumber){
        int matchNumber = lotto.getMatchNumber(winningLotto);
        Rank currentRank = Rank.Failure;

        currentRank = currentRank.setRank(matchNumber, hasBonusNumber);
        ranks.add(currentRank);
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber){
        for(int i = 0; i < lotto.getNumbers().size(); i++){
            if(lotto.getNumbers().get(i) == bonusNumber)
                return true;
        }
        return false;
    }

    public int getRankNumber(Rank rank){
        int rankNumber = 0;

        for(int i = 0; i < ranks.size(); i++){
            if (ranks.get(i) == rank)
                rankNumber++;
        }

        return rankNumber;
    }

    public List<Rank> getRanks(){
        return ranks;
    }
}
