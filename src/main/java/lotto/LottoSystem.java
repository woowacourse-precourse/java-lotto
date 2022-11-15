package lotto;

import lotto.domain.Buyer;
import lotto.domain.LottoAdmin;

public class LottoSystem {

    private LottoSystem() {
    }

    public static void run() {
        Buyer buyer = recruitBuyer();
        LottoAdmin lottoAdmin = recruitLottoAdmin();

        buyer.calculateWinningResult(lottoAdmin.getWinningNumber(), lottoAdmin.getBonusNumber());
        buyer.printStatics();
        buyer.printRateOfReturn();
    }

    private static LottoAdmin recruitLottoAdmin() {
        LottoAdmin lottoAdmin = new LottoAdmin();
        lottoAdmin.createWinningNumbers();
        lottoAdmin.createBonusNumber();

        return lottoAdmin;
    }

    private static Buyer recruitBuyer() {
        Buyer buyer = new Buyer();
        buyer.readyForBuyLotto();

        return buyer;
    }

}
