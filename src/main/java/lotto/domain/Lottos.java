package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Number.*;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buy(int quantity) {
        for (int count = ZERO.getNumber(); count < quantity; count++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber(), SIX.getNumber())));
        }

    }
}
