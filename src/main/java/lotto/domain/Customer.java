package lotto.domain;

import lotto.view.OutPutView;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Lotto> lottos = new ArrayList<>();

    public void buy(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
        OutPutView.showCustomerLotto(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
