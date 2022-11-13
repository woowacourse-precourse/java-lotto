package lotto;

import lotto.domain.Lotto;
import lotto.ui.Display;
import lotto.ui.LottoScanners;

import java.util.List;

public class LottoGameSimulator {

    private final Display display;
    private final LottoScanners scanners;

    public LottoGameSimulator() {
        this.display = new Display();
        this.scanners = new LottoScanners();
    }

    public void start() {
        List<Lotto> lottoPacks = buyLotto();
        checkLottoNumbers(lottoPacks);

        setLottoWinningNumbers();

        checkLottoResult();
    }

    public List<Lotto> buyLotto() {
        String price = requestPriceProcess();

        return List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    public String requestPriceProcess() {
        display.printRequestPrice();
        String price = scanners.inputPrice();
        display.printNewLine();

        return price;
    }

    public void checkLottoNumbers(List<Lotto> lottoPacks) {
        display.printPurchasedLottoPacks(lottoPacks);
        display.printNewLine();
    }

    public void setLottoWinningNumbers() {
        display.printRequestWinningNumber();
        String winingNumber = scanners.inputWiningNumber();
        display.printNewLine();

        display.printRequestBonusNumber();
        String bonusNumber = scanners.inputBonusNumber();
        display.printNewLine();
    }

    public void checkLottoResult() {
        display.printWinningList(0,0,0,0,0);
        display.printEarningLate(70);
        display.printNewLine();
    }
}
