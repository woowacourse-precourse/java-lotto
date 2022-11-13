package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Lotto> lottoInHand = new ArrayList<>();
    private Integer numberOfLotto = 0;

    public void buyLotto(Lotto lotto) {
        lottoInHand.add(lotto);
        numberOfLotto++;
    }

    public List<Lotto> getLottoInHand() {
        return lottoInHand;
    }

    public Integer getNumberOfLotto() {
        return numberOfLotto;
    }
}
