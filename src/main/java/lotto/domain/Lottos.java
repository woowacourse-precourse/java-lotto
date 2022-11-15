package lotto.domain;

import lotto.utils.RandomGenerator;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(int lottoCounts) {
        Stream<Lotto> automaticLottos = generateAutomatic(lottoCounts);
        List<Lotto> generatedLottos = automaticLottos.collect(Collectors.toList());
        return new Lottos(generatedLottos);
    }

    private static Stream<Lotto> generateAutomatic(int lottoCounts) {
        return Stream.generate(() -> new Lotto(RandomGenerator.generateRandomNumbers()))
                .limit(lottoCounts);
    }

    public LottoResult checkResult (WinningLotto winningLotto) {
        Map<Rank, Long> statistics = lottos.stream()
                .map(winningLotto::compareNumbers)
                .collect(Collectors.groupingBy(rank -> rank, () -> new EnumMap<>(Rank.class),
                        Collectors.counting()));
        return LottoResult.from(statistics);
    }

    public int getLottoCounts() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
