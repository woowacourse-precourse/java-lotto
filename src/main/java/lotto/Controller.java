package lotto;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() {
        int inputMoney = inputView.getMoney();
        Money lottoMoney = new Money(inputMoney);

        List<Lotto> lottoTickets = lottoGenerator.makeQuickPickTicketsBy(lottoMoney);
        outputView.printTickets(lottoTickets);


    }


}
