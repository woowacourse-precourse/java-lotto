package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {

    private static final List lottos = new ArrayList();

    public Lotto save(Lotto lotto) {
        lottos.add(lotto);
        return lotto;
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
