package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winning {

    public Map<Rank, Integer> getTotalRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber){
        Map<Rank, Integer> totalRank = new HashMap<>();
        totalRank.put(Rank.RANK1,0);
        totalRank.put(Rank.RANK2,0);
        totalRank.put(Rank.RANK3,0);
        totalRank.put(Rank.RANK4,0);
        totalRank.put(Rank.RANK5,0);
        for (Lotto lotto : lottos){
            int matchNumber = countMatchNumber(lotto, winningNumbers);
            boolean matchBonus = countBonusNumber(lotto, bonusNumber);
            increaseRankCount(totalRank, matchNumber, matchBonus);
        }
        return totalRank;
    }

    private void increaseRankCount(Map<Rank, Integer> totalRank, int matchNumber, boolean matchBonus){
      for (Rank rank : totalRank.keySet()){
          if (rank.getMatchCount() == matchNumber && rank.getBonusCount() == matchBonus){
              totalRank.put(rank, totalRank.get(rank) + 1);
          }
      }
    }


    private int countMatchNumber(Lotto lotto, List<Integer> winningNumbers){
        List<Integer> numbers = lotto.getNumbers();
        int matchNumber = 0;
        for (Integer number : numbers){
            if (winningNumbers.contains(number)){
                matchNumber += 1;
            }
        }
        return matchNumber;
    }


    private boolean countBonusNumber(Lotto lotto, int bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        return (numbers.contains(bonusNumber));
    }
}
