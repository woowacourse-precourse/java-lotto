package lotto.controller;

import static lotto.utils.Constant.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Money;
import lotto.view.Output;

public class LottoController {

    Output output;
    LottoMaker lottoMaker;

    public LottoController() {
        output = new Output();
        lottoMaker = new LottoMaker();
    }

    public List<Lotto> getLottos(Money money) {
        int many = calculateHowManyLotto(money);
        List<Lotto> lottos = lottoMaker.getLottos(many);
        output.printLottos(lottos);
        return lottos;
    }

    private int calculateHowManyLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
