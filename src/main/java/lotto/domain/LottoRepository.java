package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();


    public List<Lotto> findAll() {
        return new ArrayList<>(lottos);
    }

    public List<Integer> save(Lotto lotto) {
        lottos.add(lotto);
        return lotto.getNumbers();
    }


}
