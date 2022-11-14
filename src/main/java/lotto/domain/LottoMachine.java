package lotto.domain;

import lotto.io.Input;
import lotto.io.Output;
import lotto.util.BonusNumberValidator;
import lotto.util.PurchaseAmtValidator;
import lotto.util.WinningNumberValidator;

import java.util.LinkedList;
import java.util.List;

public class LottoMachine {

    private final Input input;
    private final NumberGenerator numberGenerator;
    private final Statistics statistics;

    private LinkedList<Integer> winningNumWithBonusList;
    private List<Lotto> quickPicks;
    private int purchaseAmt;

    public LottoMachine() {
        this.input = new Input(new PurchaseAmtValidator(), new WinningNumberValidator(), new BonusNumberValidator());
        this.numberGenerator = new NumberGenerator();
        this.statistics = new Statistics();
    }

    public void start() {
        try {
            purchaseAmt = input.enterPurchaseAmt();
            quickPicks = numberGenerator.getQuickPick(purchaseAmt);
            winningNumWithBonusList = input.enterWinningNumber();

            printStatistics();
        } catch (IllegalArgumentException e) {
            Output.printIllegalArgumentException(e.getMessage());
        }

    }

    private void printStatistics() {
        statistics.winningStatistics(quickPicks, winningNumWithBonusList, purchaseAmt);
    }

}
