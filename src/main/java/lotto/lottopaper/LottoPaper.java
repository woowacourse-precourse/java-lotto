package lotto.lottopaper;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoPaper {
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
