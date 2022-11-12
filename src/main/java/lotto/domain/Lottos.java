package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return this.lottos.iterator();
    }

    public int getLottoCount() {
        return this.lottos.size();
    }
}
