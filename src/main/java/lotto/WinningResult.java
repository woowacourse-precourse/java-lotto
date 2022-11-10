package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
     WinningNumber winningNumber;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public void winningHistory(List<Lotto> lottos) {
          List<Integer> rank = rankCount(lottos);
     }

     private List<Integer> rankCount(List<Lotto> lottos) {
          return lottos.stream()
                  .map(winningNumber::match)
                  .collect(Collectors.toList());
     }
}
