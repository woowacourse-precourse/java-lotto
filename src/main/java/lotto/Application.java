package lotto;

import lotto.Utils.Print;
import lotto.domain.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Print.askAmount();

        LottoStore store = new LottoStore();
        store.inputPurchase();

        List<Lotto> lottos = store.buyLotto();
        Print.purchasedLottos(lottos);

        LottoCompany company = new LottoCompany();

        for (Lotto lotto : lottos) {
            company.processLotto(lotto);
        }

        WinningStats stats = new WinningStats(store.getPurchase(), lottos);
        stats.print();
    }
}