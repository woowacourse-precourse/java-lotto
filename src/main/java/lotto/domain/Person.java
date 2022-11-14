package lotto.domain;

import java.util.List;

public class Person {
    private List<Lotto> lottos;

    public void buyLottos(LottoMachine lottoMachine) {
        this.lottos = lottoMachine.sellLottos();
    }
}
