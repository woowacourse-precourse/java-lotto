package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottosGenerator {
    private final NumbersGenerationStrategy strategy;

    public LottosGenerator(NumbersGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public Lottos lottos(long count) {
        List<Lotto> lottos = LongStream.range(0, count)
                .mapToObj(it -> strategy.numbers())
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList());
        return new Lottos(lottos);
    }
}
