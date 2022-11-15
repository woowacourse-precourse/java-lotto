package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;

public class LottoController {

  public void run() {
    System.out.println("LottoController.run()");
    LottoMoney lottoMoney = new LottoMoney(InputLotto.inputPurchaseMoney());
    System.out.println(lottoMoney.getMoney());
    lottoMoney.calculateLottoTicketCount();

    Lotto winningNumber = new Lotto(InputLotto.inputWinningNumber(), InputLotto.inputBonusNumber());
    System.out.println(winningNumber.getLottoNumber());
  }
  
}
