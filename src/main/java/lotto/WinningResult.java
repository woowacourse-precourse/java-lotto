package lotto;

import java.util.List;

public class WinningResult {
     WinningNumber winningNumber;

     WinningResult(WinningNumber winningNumber) {
          this.winningNumber = winningNumber;
     }
     public void winningHistory(List<Lotto> lottos) {
          for (Lotto lotto : lottos) {
               rankCount(lotto);
          }
     }

     private Integer rankCount(Lotto lotto) {

     }
}
