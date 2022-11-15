package lotto.controller;

import lotto.ExceptionHandle;

import lotto.model.computer.LottoComputer;

import lotto.model.resources.LottoWin;
import lotto.model.resources.TotalStat;
import lotto.model.resources.BonusLotto;
import lotto.model.resources.Money;
import lotto.model.resources.TotalWinningLotto;

import lotto.view.View;
import lotto.view.Message;

public class Controller {

    private final LottoComputer lottoComputer;
    private final View view;

    public Controller() {
        this.view = new View();
        this.lottoComputer = new LottoComputer();
    }

    public void run() {
        try {
            lottoComputer.buyLotto(new Money(view.readMoney()));
            printFirstAnnounce();
            LottoWin lottoWin = LottoWin.of(view.readLotto());
            printOut(Message.BONUS_WINNER_MESSAGE);
            BonusLotto bonusLotto = BonusLotto.of(view.readBonus(), lottoWin.getNumbers());
            printOut(Message.RESULT_MESSAGE);

            TotalWinningLotto totalWinningLotto = TotalWinningLotto.of(lottoWin, bonusLotto);
            printLastAnnounce(TotalStat.of(totalWinningLotto, lottoComputer));
        } catch (ExceptionHandle e) {
            System.out.println(e.getMessage());
        }
    }

    private void printFirstAnnounce() {
        view.print(Message.printAnnounce(lottoComputer.howManyLotto()));
        view.printAllLotto(lottoComputer.allLottoLines());
        printOut(Message.LOTTO_WINNER_MESSAGE);
    }

    private void printOut(Message message) {
        view.print(view.printOutput(message));
    }

    private void printLastAnnounce(TotalStat totalStat) {
        totalStat.printWinner(view);
        totalStat.printResultPercent(view, lottoComputer);
    }
}
