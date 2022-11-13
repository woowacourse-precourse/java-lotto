package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    public void start() {
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPurchasePrice());
        makeLotto(lottoMachine.getRound());
    }

    private void makeLotto(int round) {
        LottoGenerator lottoGenerator = new LottoGenerator(round);

        List<Lotto> lottoTickets = lottoGenerator.getLottoTickets();
    }
}
