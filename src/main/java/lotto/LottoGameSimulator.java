package lotto;

import lotto.domain.Lotto;
import lotto.ui.Display;

import java.util.List;

public class LottoGameSimulator {

    private final Display display;

    public LottoGameSimulator() {
        this.display = new Display();
    }

    public void start() {
        requestPriceProcess();
        announcePurchasedLottoProcess();

        requestWinningNumberProcess();
        requestBonusNumberProcess();

        announceLottoStatProcess();
    }

    public void requestPriceProcess() {
        display.printRequestPrice();
        display.printNewLine();
    }

    public void announcePurchasedLottoProcess() {
        display.printPurchasedLottoPacks(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        display.printNewLine();
    }

    public void requestWinningNumberProcess() {
        display.printRequestWinningNumber();
        display.printNewLine();
    }

    public void requestBonusNumberProcess() {
        display.printRequestBonusNumber();
        display.printNewLine();
    }

    public void announceLottoStatProcess() {
        display.printWinningList(0,0,0,0,0);
        display.printEarningLate(70);
        display.printNewLine();
    }
}
