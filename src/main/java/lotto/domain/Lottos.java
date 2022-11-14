package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class Lottos {
    private static final String NULL_MESSAGE = "Lottos 를 생성할 때 null 이 들어왔습니다";
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = Collections.unmodifiableList(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public Stream<Lotto> toStream() {
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }
}
