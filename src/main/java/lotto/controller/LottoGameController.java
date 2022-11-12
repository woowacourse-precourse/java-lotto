package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Money budget = inputBudget();

        LottoTickets lottoTickets = createLottoTickets(budget);
        outputView.outputToLottoTickets(Messages.PURCHASED_TICKET_COUNTS, lottoTickets);


    }

    public Money inputBudget() {
        String budget = inputView.inputWith(Messages.REQUEST_BUDGET_INPUT);

        return new Money(budget);
    }

    public LottoTickets createLottoTickets(Money budget) {
        long NumberOfTickets = budget.getNumberOfTickets();
        LottoGenerator lottoGenerator = new LottoGenerator();

        return lottoGenerator.generateAutoLottoTickets(NumberOfTickets);
    }

}
