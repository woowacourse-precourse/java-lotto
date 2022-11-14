package lotto;

import lotto.domain.LottoMoney;

public class LottoController {

  public void run() {
    System.out.println("LottoController.run()");
    LottoMoney lottoMoney = new LottoMoney(InputLotto.inputPurchaseMoney());
    System.out.println(lottoMoney.getMoney());
    lottoMoney.calculateLottoTicketCount();
    System.out.println(InputLotto.inputWinningNumber());
    System.out.println(InputLotto.inputBonusNumber());
  }
  
}
