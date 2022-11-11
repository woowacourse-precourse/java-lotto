package lotto;

import java.util.ArrayList;
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
     private List<Integer> rank;
     private int winningRate;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public List<Integer> winningHistory(List<Lotto> lottos) {
          this.rank = checkRank(lottos);
          return countRank(this.rank);
     }

     private List<Integer> countRank(List<Integer> rank) {
          List<Integer> rankCount = new ArrayList<>(6);

          for (Integer rankNum : rank) {
               rankCount.set(rankNum, rankCount.get(rankNum));
          }

          return rankCount;
     }

     int winningRate(Integer purchaseAmount) {

     }

     private List<Integer> checkRank(List<Lotto> lottos) {
          return lottos.stream()
                  .map(winningNumber::match)
                  .collect(Collectors.toList());
     }
}
