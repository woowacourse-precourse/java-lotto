package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult result(WinningLotto winningLotto) {
        return new LottoResult(winningLotto, lottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int count() {
        return this.lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }
}
