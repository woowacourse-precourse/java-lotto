package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Host;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.User;
import lotto.util.Printer;
import lotto.view.LottoMessage;

import java.util.List;

public class LottoController {
    private User user = new User();
    private Host host = new Host();
    private LottoMachine lottoMachine = new LottoMachine();
    private Lotto winningLotto;

    public void init() {
        playLotto();
    }

    private void playLotto() {
        int lottoNum = sell();
        Printer.divide();
        List<Lotto> lottos = issue(lottoNum);
        user.receive(lottos);
        Printer.divide();
        draw();

    }

    private int sell() {
        Printer.print(LottoMessage.INPUT_AMOUNT.getMessage());
        int amount = user.buy();
        return amount / 1000;
    }

    private List<Lotto> issue(int lottoNum) {
        List<Lotto> lottos = lottoMachine.issueLottos(lottoNum);
        Printer.print(lottoNum + LottoMessage.PURCHASE_DONE.getMessage());
        Printer.printLottos(lottos);
        return lottos;
    }

    private void draw() {
        Printer.print(LottoMessage.INPUT_NUMBERS.getMessage());
        winningLotto = host.drawNumbers();
    }

}
