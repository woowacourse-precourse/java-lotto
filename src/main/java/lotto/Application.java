package lotto;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = Ui.inputPurchaseAmount();
        int lottoTickets = Ui.getLottoTickets(purchaseAmount);
    }
}
