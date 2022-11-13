package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class Lottos {
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

    public Stream<Lotto> toStream() {
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }
}
