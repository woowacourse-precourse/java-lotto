package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Lotto> lottoInHand = new ArrayList<>();

    public void buyLotto(Lotto lotto) {
        lottoInHand.add(lotto);
    }

    public List<Lotto> getLottoInHand() {
        return lottoInHand;
    }
}
