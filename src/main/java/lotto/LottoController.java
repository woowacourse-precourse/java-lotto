package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    
    public void run() {
        LottoMoney lottoMoney = new LottoMoney(InputView.inputPurchaseMoney());
        lottoMoney.calculateLottoTicketCount();
        int lottoTicketCount = lottoMoney.getLottoTicketCount();
        OutputView.outputLottoTicketCount(lottoTicketCount);

        Lottos lottos = new Lottos(lottoTicketCount);
        OutputView.outputLottoTicket(lottos);

        Lotto winningNumber = new Lotto(InputView.inputWinningNumber());
        LottoNumber bonusNumber = new LottoNumber(winningNumber, InputView.inputBonusNumber());

        LottoResult lottoResult = LottoResult.calculateLottoResult(lottos, winningNumber, bonusNumber);
        OutputView.outputLottoRankResult(lottoResult);
        OutputView.outputLottoProfit(lottoResult.calculateLottoProfit(lottoMoney));
    }
}
