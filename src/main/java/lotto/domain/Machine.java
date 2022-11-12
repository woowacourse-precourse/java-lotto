package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class Machine {

    public void start() {
        int quantity = Counter.getQuantity(InputView.amount());
        List<Lotto> lottos = LottoGenerator.getLottos(quantity);
    }
}
