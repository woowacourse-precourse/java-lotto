package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {
    private final List<Integer> winNumbers;

    public WinLotto(Lotto winLotto, int bonus) {
        winNumbers = new ArrayList<>(winLotto.getNumbers());
    }

}
