package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = Collections.unmodifiableList(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
