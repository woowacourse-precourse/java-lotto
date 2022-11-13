package lotto;

import lotto.domain.Lotto;
import lotto.domain.UserInputScanner;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInputScanner userScanner = new UserInputScanner();
        final int PURCHASE_MONEY = userScanner.askPurchaseMoney();

        if (PURCHASE_MONEY == -1) {
            return;
        }

        List<Lotto> lottos = Lotto.buyLottosByPurchaseMoney( PURCHASE_MONEY );
    }
}
