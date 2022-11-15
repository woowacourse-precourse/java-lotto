package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;

public class LottoController {
    
  public void run() {
        System.out.println("LottoController.run()");
        LottoMoney lottoMoney = new LottoMoney(InputLotto.inputPurchaseMoney());
        lottoMoney.calculateLottoTicketCount();
        int lottoTicketCount = lottoMoney.getLottoTicketCount();

      // Lotto winningNumber = new Lotto(InputLotto.inputWinningNumber(), InputLotto.inputBonusNumber());
      // System.out.println(winningNumber.getLottoNumber());
    
      Lottos lottos = new Lottos(lottoTicketCount);
      for (Lotto lotto : lottos.getLottos()) {
          System.out.println(lotto.getLottoNumber());
      }
  }
}
