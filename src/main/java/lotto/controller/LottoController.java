package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.util.Printer;
import lotto.view.LottoMessage;
import lotto.view.ResultMessage;

import java.util.List;

public class LottoController {
    private User user = new User();
    private Host host = new Host();
    private LottoMachine lottoMachine = new LottoMachine();
    private Lotto winningLotto;
    private Bonus bonus;

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
        Printer.divide();

        showResult();
    }

    private int sell() {
        Printer.print(LottoMessage.INPUT_AMOUNT.getMessage());
        int amount = user.buy();
        return amount / 1000;
    }

    private List<Lotto> issue(int lottoNum) {
        List<Lotto> lottos = lottoMachine.issueLottos(lottoNum);
        Printer.printf(LottoMessage.PURCHASE_DONE.getMessage(), lottoNum);
        Printer.printLottos(lottos);
        return lottos;
    }

    private void draw() {
        Printer.print(LottoMessage.INPUT_NUMBERS.getMessage());
        winningLotto = host.drawNumbers();
        Printer.divide();
        Printer.print(LottoMessage.INPUT_BONUS.getMessage());
        bonus = host.drawBonus(winningLotto);
    }

    private void showResult() {
        int[] rank = lottoMachine.determineWinners(user, winningLotto, bonus);
        Printer.print(ResultMessage.RESULT.getMessage());
    }

}
