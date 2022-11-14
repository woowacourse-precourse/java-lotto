package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.ui.Display;
import lotto.ui.LottoScanners;

import java.util.List;
import java.util.Map;

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
        String price = requestPriceProcess();
        List<Lotto> lottoPacks = buyLotto(price);
        checkLottoNumbers(lottoPacks);

        String winningNumber = requestWinningNumber();
        String bonusNumber = requestBonusNumber();

        Map<LottoMatch, Integer> matchedCount = checkWinningPrize(lottoPacks, winningNumber, bonusNumber);
        checkEarningRate(price, matchedCount);
    }

    public List<Lotto> buyLotto(String price) {
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

    public String requestWinningNumber() {
        display.printRequestWinningNumber();
        String winingNumber = scanners.inputWiningNumber();

        display.printNewLine();

        return winingNumber;
    }

    public String requestBonusNumber() {
        display.printRequestBonusNumber();
        String bonusNumber = scanners.inputBonusNumber();

        display.printNewLine();

        return bonusNumber;
    }

    public Map<LottoMatch, Integer> checkWinningPrize(List<Lotto> lottoPacks, String winingNumber, String bonusNumber) {
        Map<LottoMatch, Integer> matchedCount = controller.calWinningPrize(lottoPacks, winingNumber, bonusNumber);

        display.printWinningList(matchedCount.getOrDefault(LottoMatch.THREE, 0),
                matchedCount.getOrDefault(LottoMatch.FOUR, 0),
                matchedCount.getOrDefault(LottoMatch.FIVE, 0),
                matchedCount.getOrDefault(LottoMatch.BONUS, 0),
                matchedCount.getOrDefault(LottoMatch.SIX, 0));

        return matchedCount;
    }

    public void checkEarningRate(String price, Map<LottoMatch, Integer> matchedCount) {
        display.printEarningLate(controller.calEarningRate(price, matchedCount));
        display.printNewLine();
    }
}
