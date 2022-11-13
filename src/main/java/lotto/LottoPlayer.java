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
        printPurchaseList(lottos);
        printManager.printRequestWinningNumber();
        Lotto winningNumber = inputManager.inputWinningNumbers();
        printManager.printRequestBonusNumber();
        int bonusNumber = inputManager.inputBonusNumber(winningNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumber, bonusNumber);
        List<LottoGrade> lottoResults = lottoMatcher.matchAll(lottos);
        Map<LottoGrade, Integer> analyze = lottoAnalyst.analyze(lottoResults);
        double yield = lottoAnalyst.getYield(analyze);
        analyze.remove(LottoGrade.BANG);
        analyze.forEach((key, value) -> {
            System.out.printf(String.valueOf(ConsoleMessage.STATISTICS_ELEMENT_FORMAT), key, value);
            System.out.print(ConsoleMessage.NEW_LINE);
        });
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_YIELD), Math.round(yield*100)/100.0);
    }

    private void printPurchaseList(List<Lotto> lottos) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_PURCHASE), lottos.size());
        System.out.print(ConsoleMessage.NEW_LINE);
        lottos.forEach(System.out::println);
        System.out.print(ConsoleMessage.NEW_LINE);
    }
}
