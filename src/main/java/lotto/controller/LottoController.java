package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.domain.UserNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPurchasePrice());
        makeLotto(lottoMachine.getRound());
        UserNumber userNumber = new UserNumber(InputView.inputWinNumbers(), InputView.inputBonusNumbers());
    }

    private void makeLotto(int round) {
        LottoGenerator lottoGenerator = new LottoGenerator(round);
        List<Lotto> lottoTickets = lottoGenerator.getLottoTickets();

        OutputView.printTicketNumber(round);
        for (Lotto lotto : lottoTickets) {
            OutputView.printTickets(lotto.getNumbers());
        }
    }
}
