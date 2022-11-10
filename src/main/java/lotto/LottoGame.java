package lotto;

public class LottoGame {
    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Print.purchaseLotto(lottoTickets);
    }
}
