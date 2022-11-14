package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> publishedLotto = new ArrayList<>();

    public void save(Lotto lotto) {
        publishedLotto.add(lotto);
    }

    public List<Lotto> getPublishedLotto() {
        return this.publishedLotto;
    }
}
