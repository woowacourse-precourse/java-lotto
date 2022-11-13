package lotto;

import java.util.List;
import java.util.Map;

public class LottoPlayer {
    private final InputManager inputManager = new InputManager();
    private final LottoFactory lottoFactory = new LottoFactory();
    private final LottoAnalyst lottoAnalyst= new LottoAnalyst();

    public void play() {
        inputAll();
    }

    private void inputAll() {
        int lottoCount = requestInputPurchaseMoney();
        List<Lotto> lottos = lottoFactory.create(lottoCount);
        printPurchaseList(lottos);
        Lotto winningNumber = requestInputWinningNumbers();
        int bonusNumber = requestInputBonusNumber(winningNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumber, bonusNumber);
        List<LottoGrade> lottoResults = lottoMatcher.matchAll(lottos);
        Map<LottoGrade, Integer> analyze = lottoAnalyst.analyze(lottoResults);
        analyze.remove(LottoGrade.BANG);
        analyze.forEach((key, value) -> {
            System.out.printf(String.valueOf(ConsoleMessage.STATISTICS_ELEMENT_FORMAT), key, value);
            System.out.print(ConsoleMessage.NEW_LINE);
        });
    }

    private void printPurchaseList(List<Lotto> lottos) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_PURCHASE), lottos.size());
        System.out.print(ConsoleMessage.NEW_LINE);
        lottos.forEach(System.out::println);
        System.out.print(ConsoleMessage.NEW_LINE);
    }

    private int requestInputPurchaseMoney() {
        System.out.println(ConsoleMessage.REQUEST_PURCHASE);
        return inputManager.inputPurchaseAmount();
    }
    private Lotto requestInputWinningNumbers() {
        System.out.println(ConsoleMessage.REQUEST_WINNING_NUMBERS);
        return inputManager.inputWinningNumbers();
    }

    private int requestInputBonusNumber(Lotto winningNumber) {
        System.out.println(ConsoleMessage.REQUEST_BONUS_NUMBER);
        return inputManager.inputBonusNumber(winningNumber);
    }
}
