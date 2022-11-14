package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> randomNumbers) {
        lottos = randomNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining());
    }

    public List<Lotto> get() {
        return lottos;
    }
}
