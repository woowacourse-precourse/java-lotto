package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();


    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> save(Lotto lotto) {
        lottos.add(lotto);
        return lotto.getNumbers();
    }

}
