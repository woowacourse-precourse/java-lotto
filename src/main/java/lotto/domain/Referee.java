package lotto.domain;

import lotto.constant.Rank;

public class Referee {
    public Rank getLottoRank(int winningCount, boolean hasBonus) {
        
        if (winningCount == 5) {
            return judgeRankTwoOrThree(hasBonus);
        }
        
        Rank[] ranks = Rank.values();
        
        for (int index = 0; index < ranks.length; index++) {
            if (ranks[index].getCorrect() == winningCount) {
                return ranks[index];
            }
        }
        
        return Rank.NONE;
    }
    
    public Rank judgeRankTwoOrThree(boolean hasBonus) {
        
        if (hasBonus) {
            return Rank.SECOND;
        }
        
        return Rank.THIRD;
    }

}