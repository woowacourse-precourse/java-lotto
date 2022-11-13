package lotto;

public class LottoStore {
    private static InputView inputView;

    public LottoStore() {
        inputView = new InputView();
    }

    public void playLottoGame() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
    }

    private PurchaseAmount setPurchaseAmount() {
        return new PurchaseAmount(inputView.enterAmount());
    }
}
