package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class WinningResult {
     WinningNumber winningNumber;
     private HashMap<Rank, Integer> rankCount;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public HashMap<Rank, Integer> winningHistory(List<Lotto> lottos) {
          List<Rank> rank = checkRank(lottos);
          return countRank(rank);
     }

     private HashMap<Rank, Integer> countRank(List<Rank> rank) {
          this.rankCount = setRankCount();

          for (Rank rankNum : rank) {
               rankCount.put(rankNum, rankCount.get(rankNum) + 1);
          }
          return rankCount;
     }

     private HashMap<Rank, Integer> setRankCount() {
          HashMap<Rank, Integer> result = new HashMap<>();
          result.put(Rank.NONE, 0);
          result.put(Rank.FIRST, 0);
          result.put(Rank.SECOND, 0);
          result.put(Rank.THIRD, 0);
          result.put(Rank.FOURTH, 0);
          result.put(Rank.FIFTH, 0);

          return result;
     }

     float winningRate(Integer purchaseAmount) {
          int winningAmount = 0;
          float result;

          Iterator<Map.Entry<Rank, Integer>> entry = rankCount.entrySet().iterator();

          while (entry.hasNext()) {
               Map.Entry<Rank, Integer> element = entry.next();
               winningAmount += element.getKey().getWinningAmount() * element.getValue();
          }

          result = winningAmount / (float)purchaseAmount * 100;

          return result;
     }

     private List<Rank> checkRank(List<Lotto> lottos) {
          return lottos.stream()
                  .map(winningNumber::match)
                  .collect(Collectors.toList());
     }
}
