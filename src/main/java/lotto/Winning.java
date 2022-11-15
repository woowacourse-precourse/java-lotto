package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winning {

    public Map<Rank, Integer> getTotalRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber){
        Map<Rank, Integer> totalRank = Map.of(Rank.RANK1,0,Rank.RANK2,0, Rank.RANK3, 0, Rank.RANK4, 0, Rank.RANK5,0);
        for (Lotto lotto : lottos){
            int matchNumber = countMatchNumber(lotto, winningNumbers);
            boolean matchBonus = countBonusNumber(lotto, bonusNumber);
            increaseRankCount(totalRank, matchNumber, matchBonus);
        }
        return totalRank;
    }

    private void increaseRankCount(Map<Rank, Integer> totalRank, int matchNumber, boolean matchBonus){
        if (matchNumber == 6) {
            totalRank.put(Rank.RANK1, totalRank.get(Rank.RANK1) + 1);
        }
        else if (matchNumber == 5 && matchBonus){
            totalRank.put(Rank.RANK2, totalRank.get(Rank.RANK2) + 1);
        }
        else if (matchNumber == 5){
            totalRank.put(Rank.RANK3, totalRank.get(Rank.RANK3) + 1);
        }
        else if (matchNumber == 4){
            totalRank.put(Rank.RANK4, totalRank.get(Rank.RANK4) + 1);
        }
        else if (matchNumber == 3){
            totalRank.put(Rank.RANK5, totalRank.get(Rank.RANK5) + 1);
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
