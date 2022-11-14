package lotto.controller;

import lotto.domain.GradesResult;
import lotto.domain.GradingMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicketSeller;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private Output output;
    private LottoTicket lottoTicket;

    public LottoController() {
        this.output = new Output();
    }

    public void run() {
        LottoMoney money = Input.inputMoney();
        buyLotto(money);
        createStatistics(money);
    }

    private void buyLotto(LottoMoney money) {
        lottoTicket = LottoTicketSeller.buyLottoByMoney(money);
        output.printPurchaseInfo(lottoTicket);
    }

    private void createStatistics(LottoMoney money) {
        GradingMachine gradingMachine = new GradingMachine(Input.inputWinnerLotto(), Input.inputBonusNumber());
        GradesResult gradesResult = gradingMachine.gradesResultByLottoTicket(lottoTicket);
        output.printLottoResult(gradesResult.getGradesResult());
        output.printLottoYield(gradesResult.calculateYield(money));
    }
}
