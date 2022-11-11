package lotto;

import java.util.*;
import java.util.stream.Collectors;

enum Rank{
     NONE(0), FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000), FOURTH(50_000), FIFTH(5_000);
     int value;
     Rank(int value){
          this.value = value;
     }
     public int getValue(){
          return value;
     }
}
public class WinningResult {
     WinningNumber winningNumber;
     private HashMap<Rank, Integer> rankCount;
     private int winningRate;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public HashMap<Rank, Integer> winningHistory(List<Lotto> lottos) {
          List<Rank> rank = checkRank(lottos);
          return countRank(rank);
     }

     private HashMap<Rank, Integer> countRank(List<Rank> rank) {
          this.rankCount = new HashMap<>();
          rankCount.put(Rank.NONE, 0);
          rankCount.put(Rank.FIRST, 0);
          rankCount.put(Rank.SECOND, 0);
          rankCount.put(Rank.THIRD, 0);
          rankCount.put(Rank.FOURTH, 0);
          rankCount.put(Rank.FIFTH, 0);

          for (Rank rankNum : rank) {
               rankCount.put(rankNum, rankCount.get(rankNum) + 1);
          }

          return rankCount;
     }

     float winningRate(Integer purchaseAmount) {
          int winningAmout = 0;
          float result = 0f;

          Iterator<Map.Entry<Rank, Integer>> entry = rankCount.entrySet().iterator();

          while (entry.hasNext()) {
               Map.Entry<Rank, Integer> element = entry.next();
               winningAmout += element.getKey().value * element.getValue();
          }

          result = winningAmout / (float)purchaseAmount * 100;

          return result;
     }

     private List<Rank> checkRank(List<Lotto> lottos) {
          return lottos.stream()
                  .map(winningNumber::match)
                  .collect(Collectors.toList());
     }
}
