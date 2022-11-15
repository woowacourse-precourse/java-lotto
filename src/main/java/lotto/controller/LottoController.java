package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Statistics;
import lotto.domain.Judgement;
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
    }

    private void printPurchaseList(Buyer buyer) {
        messagePrinter.printDynamicLottoAmount(buyer);
        messagePrinter.printDynamicLottosBought(buyer);
    }
}
