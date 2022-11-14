package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = Ui.inputPurchaseAmount();
        int lottoTickets = LottoVendingMachine.getLottoTickets(purchaseAmount);
        List<Lotto> lottos = LottoVendingMachine.getLottos(lottoTickets);
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        System.out.println(lottoDrawMachine.getWinningNumbers().getNumbers());
    }
}
