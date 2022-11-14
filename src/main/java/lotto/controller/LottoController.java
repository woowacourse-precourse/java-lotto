package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.util.Calculator;
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
    private static final int LOTTO_PRICE = 1000;

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
        return amount / LOTTO_PRICE;
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
        Printer.printf(ResultMessage.THREE_HIT.getMessage(), rank[5]);
        Printer.printf(ResultMessage.FOUR_HIT.getMessage(), rank[4]);
        Printer.printf(ResultMessage.FIVE_HIT.getMessage(), rank[3]);
        Printer.printf(ResultMessage.FIVE_HIT_WITH_BONUS.getMessage(), rank[2]);
        Printer.printf(ResultMessage.SIX_HIT.getMessage(), rank[1]);

        double profit = Calculator.rateProfit(user.getPay(), rank);
        Printer.printf(ResultMessage.RATE_PROFIT.getMessage(), profit);
    }


}
