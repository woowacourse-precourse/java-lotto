package lotto.domain;

import java.util.List;

public class Customer {

    private List<Lotto> lottos;

    public void buyLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> showLottos() {
        return lottos;
    }
}
