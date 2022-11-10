package lotto.service;

import java.util.Collections;
import java.util.List;
import lotto.Computer;
import lotto.Lotto;

public class ComputerSpy extends Computer {
    boolean isCalled = false;

    @Override
    public List<Integer> getResult(List<Lotto> lottos, List<Integer> winns, int bonus) {
        isCalled = true;
        return Collections.EMPTY_LIST;
    }
}
