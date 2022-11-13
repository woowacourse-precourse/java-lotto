package lotto.controller;

import lotto.domain.GradesResult;
import lotto.domain.GradingMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Seller;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Output output;
    private LottoTicket lottoTicket;

    public LottoController(Output output) {
        this.output = output;
    }

    public void run() {
        Money money = Input.inputMoney();
        buyLotto(money);
        createStatistics(money);
    }

    private void buyLotto(Money money) {
        lottoTicket = Seller.buyLottoByMoney(money);
        output.printPurchaseInfo(lottoTicket);
    }

    private void createStatistics(Money money) {
        GradingMachine gradingMachine = new GradingMachine(Input.inputWinnerLotto(), Input.inputBonusNumber());
        GradesResult gradesResult = gradingMachine.getGradesResultByLottoTicket(lottoTicket);
        output.printLottoResult(gradesResult.getGradeResult());
        output.printLottoYield(gradesResult.calculateYield(money));
    }

}
