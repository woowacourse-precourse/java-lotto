package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final String DELIMITER = "\n";

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
