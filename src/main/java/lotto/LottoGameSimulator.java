package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.ui.Display;
import lotto.ui.LottoScanners;
import lotto.ui.LottoValidator;

import java.util.List;

public class LottoGameSimulator {

    private final Display display;
    private final LottoScanners scanners;
    private final LottoController controller;

    public LottoGameSimulator() {
        this.display = new Display();
        this.scanners = new LottoScanners();
        this.controller = new LottoController();
    }

    public void start() {
        List<Lotto> lottoPacks = buyLotto();
        checkLottoNumbers(lottoPacks);

        setLottoWinningNumbers();

        checkLottoResult();
    }

    public List<Lotto> buyLotto() {
        String price = requestPriceProcess();

        return controller.create(price);
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

        LottoValidator.validateBonusNumberDuplication(bonusNumber, winingNumber);
    }

    public void checkLottoResult() {
        display.printWinningList(0,0,0,0,0);
        display.printEarningLate(70);
        display.printNewLine();
    }
}
