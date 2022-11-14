package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.User;
import lotto.util.Printer;
import lotto.view.LottoMessage;

import java.util.List;

public class LottoController {
    private User user = new User();
    private LottoMachine lottoMachine = new LottoMachine();

    public void init() {
        Printer.print(LottoMessage.INPUT_AMOUNT.getMessage());
        sell();
    }

    private void sell() {
        int amount = user.buy();
        int lottoNum = amount / 1000;
        Printer.divide();

        List<Lotto> lottos = lottoMachine.issueLottos(lottoNum);
        Printer.print(lottoNum + LottoMessage.PURCHASE_DONE.getMessage());
        Printer.printLottos(lottos);
    }

}
