package lotto;

import java.util.List;

public class LottoPlayer {
    private final InputManager inputManager = new InputManager();
    private final PrintManager printManager = new PrintManager();
    private final LottoFactory lottoFactory = new LottoFactory();
    private final LottoAnalyst lottoAnalyst = new LottoAnalyst();

    private int lottoCount;
    private Lottos lottos;
    private LottoMatcher lottoMatcher;

    public void play() {
        purchaseLotto();
        insertLottoNumbers();
        printLottoResult();
    }

    private void printLottoResult() {
        List<LottoGrade> lottoResults = lottoMatcher.matchAll(lottos);
        LottoGradeCounter analyze = lottoAnalyst.analyze(lottoResults);
        double yield = lottoAnalyst.getYield(analyze);
        printManager.printWinningStatus(analyze, yield);
    }

    private void insertLottoNumbers() {
        Lotto winningNumber = inputManager.inputWinningNumbers();
        printManager.printRequestBonusNumber();
        int bonusNumber = inputManager.inputBonusNumber(winningNumber);
        lottoMatcher = new LottoMatcher(winningNumber, bonusNumber);
    }

    private void purchaseLotto() {
        printManager.printRequestPrice();
        lottoCount = inputManager.inputPurchaseAmount();
        lottos = lottoFactory.create(lottoCount);
        printManager.printLottoList(lottos);
        printManager.printRequestWinningNumber();
    }
}
