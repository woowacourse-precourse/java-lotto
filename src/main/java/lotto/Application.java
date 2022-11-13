package lotto;

import lotto.domain.Buyer;
import lotto.domain.LottoAdmin;

public class Application {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.readyForBuyLotto();
        buyer.buyLotto();

        LottoAdmin lottoAdmin = new LottoAdmin(buyer);
        lottoAdmin.createWinningNumbers();
        lottoAdmin.createBonusNumber();
    }

}
