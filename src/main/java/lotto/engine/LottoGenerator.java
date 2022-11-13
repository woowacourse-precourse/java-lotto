package lotto.engine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Lotto;

public class LottoGenerator {
    private static final int MINIMUM_LOTTO_COUNT = 1;

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottos(int count) {
        if (count < MINIMUM_LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }

        return Stream.generate(() -> new Lotto(numberGenerator.generate()))
                .limit(count)
                .collect(Collectors.toList());
    }
}
