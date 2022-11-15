package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.User;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

public class LottoGame {

    public void start() {
        List<Lotto> lottos =  buyLottos();
        Buyer buyer = new User(lottos);
    }

    private List<Lotto> buyLottos() {
        int money = LottoGenerator.enterToBuyLottoForMoney();
        int lottoCount = LottoGenerator.findLottoCountByMoney(money);
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            buyLotto(lottos);
        }
        return lottos;
    }

    private void buyLotto(List<Lotto> lottos) {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        lottos.add(lotto);
        System.out.println(lotto.getNumbers());
    }
}
