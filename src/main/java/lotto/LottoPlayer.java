package lotto;

import java.util.List;

public class LottoPlayer {
    private final InputManager inputManager = new InputManager();
    private final LottoFactory lottoFactory = new LottoFactory();
    public void play() {
        inputAll();
    }

    private void inputAll() {
        int lottoCount = requestInputPurchaseMoney();
        List<Lotto> lottos = lottoFactory.create(lottoCount);
        printPurchaseList(lottos);
        Lotto winningNumber = requestInputWinningNumbers();
        requestInputBonusNumber(winningNumber);
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
