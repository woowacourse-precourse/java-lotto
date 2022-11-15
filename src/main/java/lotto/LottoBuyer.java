package lotto;

public class LottoBuyer {
    int purchasingAmount;

    public LottoTickets buyLotto(InputView inputView, LottoManager lottoManager) {
        purchasingAmount = inputView.inputMoney();
        return lottoManager.generateLottoTickets(purchasingAmount);
    }

    public int getPurchasingAmount() {
        return purchasingAmount;
    }
}
