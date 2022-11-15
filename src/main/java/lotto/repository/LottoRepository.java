package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {

    private static final List<Lotto> lottos = new ArrayList<Lotto>();

    public Lotto save(Lotto lotto) {
        lottos.add(lotto);
        return lotto;
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
