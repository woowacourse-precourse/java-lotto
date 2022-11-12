package lotto.domain;

import lotto.view.InputView;

public class Machine {

    public void start() {
        Counter.getQuantity(InputView.amount());
    }
}
