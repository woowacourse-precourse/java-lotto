package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int purchaseAmount = Ui.inputPurchaseAmount();
            int lottoTickets = LottoVendingMachine.getLottoTickets(purchaseAmount);
            List<Lotto> lottos = LottoVendingMachine.getLottos(lottoTickets);
            LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
            lottoDrawMachine.viewPrizes(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
