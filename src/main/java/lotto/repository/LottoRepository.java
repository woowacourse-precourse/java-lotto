package lotto.repository;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private static final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
