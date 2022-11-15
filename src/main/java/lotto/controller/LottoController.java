package lotto.controller;

import lotto.domain.*;
import lotto.view.print.MessagePrinter;
import lotto.view.scanner.NumberScanner;

public class LottoController {
    private NumberScanner numberScanner;
    private MessagePrinter messagePrinter;
    private Statistics statistics;
    private Judgement judgement;

    public LottoController(NumberScanner numberScanner, MessagePrinter messagePrinter, Statistics statistics, Judgement judgement) {
        this.numberScanner = numberScanner;
        this.messagePrinter = messagePrinter;
        this.statistics = statistics;
        this.judgement = judgement;
    }

    public void start() {
        messagePrinter.printStaticPaymentNotification();
        Buyer buyer = new Buyer(numberScanner.inputPayment());
        printPurchaseList(buyer);

        messagePrinter.printStaticWinningLottoNumbersNotification();
        Lotto winning = new Lotto(numberScanner.inputWinningLottoNumbers());

        messagePrinter.printStaticBonusNumberNotification();
        Bonus bonus = new Bonus(numberScanner.inputBonusNumber());

        WinningLotto winningLotto = new WinningLotto(winning, bonus);
        checkAndRecord(buyer, winningLotto);

    }

    private void printPurchaseList(Buyer buyer) {
        messagePrinter.printDynamicLottoAmount(buyer);
        messagePrinter.printDynamicLottosBought(buyer);
    }

    private void checkAndRecord(Buyer buyer, WinningLotto winningLotto) {
        for (Lotto lotto : buyer.getLottos()) {
            Rank rank = judgement.getLottoRank(lotto, winningLotto);
            statistics.record(rank);
        }
    }
}
