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
        List<Lotto> lottoPacks = buyLottoProcess();

        String winningNumber = setWinningNumber();
        String bonusNumber = setBonusNumber();

        checkLottoResult(lottoPacks, winningNumber, bonusNumber);
    }

    public List<Lotto> buyLottoProcess() {
        String price = askLottoPrice();
        List<Lotto> lottoPacks = controller.create(price);

        display.printLottoPacks(lottoPacks);
        display.printNewLine();

        return lottoPacks;
    }

    public String askLottoPrice() {
        display.printRequestPrice();
        String price = scanners.inputPrice();

        display.printNewLine();

        return price;
    }

    public String setWinningNumber() {
        display.printRequestWinningNumber();
        String winingNumber = scanners.inputWiningNumber();

        display.printNewLine();

        return winingNumber;
    }

    public String setBonusNumber() {
        display.printRequestBonusNumber();
        String bonusNumber = scanners.inputBonusNumber();

        display.printNewLine();

        return bonusNumber;
    }

    public void checkLottoResult(List<Lotto> lottoPacks, String winningNumber, String bonusNumber) {
        Map<LottoMatch, Integer> matchedLottoCount = checkWinningPrize(lottoPacks, winningNumber, bonusNumber);

        checkEarningRate(lottoPacks, matchedLottoCount);
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

    public void checkEarningRate(List<Lotto> lottoPacks, Map<LottoMatch, Integer> matchedCount) {
        String price = String.valueOf(lottoPacks.size() / 1000);

        display.printEarningLate(controller.calEarningRate(price, matchedCount));
        display.printNewLine();
    }
}
