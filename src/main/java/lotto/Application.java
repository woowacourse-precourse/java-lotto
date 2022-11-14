package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int purchaseAmount = Ui.inputPurchaseAmount();
            int lottoTickets = LottoVendingMachine.getLottoTickets(purchaseAmount);
            List<Lotto> lottos = LottoVendingMachine.getLottos(lottoTickets);
            LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
