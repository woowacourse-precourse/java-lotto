package lotto;

public class LottoPlayer {
    private final InputManager inputManager = new InputManager();
    public void play() {
        inputAll();
    }

    private void inputAll() {
        int lottoCount = requestInputPurchaseMoney();
        Lotto winningNumber = requestInputWinningNumbers();
        requestInputBonusNumber(winningNumber);
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
