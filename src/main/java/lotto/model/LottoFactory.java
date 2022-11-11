package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoFactory {

    public static Lottos generate(int size) {
        List<Lotto> lottos = Stream.generate(LottoFactory::generate)
                .limit(size)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.NUMBER_LOWER_BOUNDS
                                                               , Lotto.NUMBER_UPPER_BOUNDS, Lotto.NUMBERS_SIZE);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
