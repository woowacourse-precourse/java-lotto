package lotto;

import java.util.List;
import java.util.Map;

public class LottoPlayer {
    private final InputManager inputManager = new InputManager();
    private final PrintManager printManager = new PrintManager();
    private final LottoFactory lottoFactory = new LottoFactory();
    private final LottoAnalyst lottoAnalyst= new LottoAnalyst();

    public void play() {
        inputAll();
    }

    private void inputAll() {
        printManager.printRequestPrice();
        int lottoCount = inputManager.inputPurchaseAmount();
        List<Lotto> lottos = lottoFactory.create(lottoCount);
        printManager.printLottoList(lottos);
        printManager.printRequestWinningNumber();
        Lotto winningNumber = inputManager.inputWinningNumbers();
        printManager.printRequestBonusNumber();
        int bonusNumber = inputManager.inputBonusNumber(winningNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumber, bonusNumber);
        List<LottoGrade> lottoResults = lottoMatcher.matchAll(lottos);
        Map<LottoGrade, Integer> analyze = lottoAnalyst.analyze(lottoResults);
        double yield = lottoAnalyst.getYield(analyze);
        printManager.printWinningStatus(analyze, yield);
    }
}
