package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoController {
    
    public void run() {
        System.out.println("LottoController.run()");
        LottoMoney lottoMoney = new LottoMoney(InputLotto.inputPurchaseMoney());
        lottoMoney.calculateLottoTicketCount();
        int lottoTicketCount = lottoMoney.getLottoTicketCount();

        // Lotto winningNumber = new Lotto(InputLotto.inputWinningNumber());
        // LottoNumber bonusNumber = new LottoNumber(InputLotto.inputBonusNumber());

        // System.out.println(winningNumber.getLottoNumber());
        // System.out.println(bonusNumber.getLottoNumber());

        // DEBUG
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);

        Lottos lottos = new Lottos(lottoTicketCount);
        LottoResult lottoResult = LottoResult.calculateLottoResult(lottos, winningNumber, bonusNumber);
        System.out.println(lottoResult.getLottoResult());
        System.out.println(lottoResult.calculateLottoProfit(lottoMoney));

    }
}
