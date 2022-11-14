package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPurchasePrice());
        List<Lotto> lottoTickets = makeLotto(lottoMachine.getRound());
        UserNumber userNumber = new UserNumber(InputView.inputWinNumbers(), InputView.inputBonusNumbers());
        calculateResult(lottoTickets, userNumber, lottoMachine.getPurchasePrice());
    }

    private List<Lotto> makeLotto(int round) {
        LottoGenerator lottoGenerator = new LottoGenerator(round);
        List<Lotto> lottoTickets = lottoGenerator.getLottoTickets();

        OutputView.printTicketNumber(round);
        for (Lotto lotto : lottoTickets) {
            OutputView.printTickets(lotto.getNumbers());
        }
        return lottoTickets;
    }

    private void calculateResult(List<Lotto> lottoTickets, UserNumber userNumber, int purchaseMoney) {
        RankCalculator rankCalculator = new RankCalculator(lottoTickets, userNumber);
        ProfitCalculator profitCalculator = new ProfitCalculator(rankCalculator.getRanks(), purchaseMoney);
    }
}
