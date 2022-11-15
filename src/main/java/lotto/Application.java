package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.User;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.seller.LottoMachine;
import lotto.domain.seller.Seller;
import lotto.ui.UI;

public class Application {

    public static void main(String[] args) {
        try {
            List<Lotto> lottos = buyLottos();
            Buyer buyer = new User(lottos);

            WinningLotto winningLotto = LottoGenerator.createWinningLottoWithEnterNumbers();
            Seller seller = new LottoMachine(winningLotto);
            LottoGame lottoGame = new LottoGame(buyer, seller);
            lottoGame.start();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Lotto> buyLottos() {
        int money = LottoGenerator.enterToBuyLottoForMoney();
        int lottoCount = LottoGenerator.findLottoCountByMoney(money);
        UI.printPurchasedLottoCount(lottoCount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            buyLotto(lottos);
        }
        return lottos;
    }

    private static void buyLotto(List<Lotto> lottos) {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        lottos.add(lotto);
        UI.printLottoNumbers(lotto.getNumbers());
    }
}
