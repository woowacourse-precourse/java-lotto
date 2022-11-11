package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     private HashMap<Rank, Integer> rankcount;
     private int winningRate;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public HashMap<Rank, Integer> winningHistory(List<Lotto> lottos) {
          List<Rank> rank = checkRank(lottos);
          return countRank(rank);
     }

     private HashMap<Rank, Integer> countRank(List<Rank> rank) {
          HashMap<Rank, Integer> rankCount = new HashMap<>();
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

          return result;
     }

     private List<Rank> checkRank(List<Lotto> lottos) {
          return lottos.stream()
                  .map(winningNumber::match)
                  .collect(Collectors.toList());
     }
}
