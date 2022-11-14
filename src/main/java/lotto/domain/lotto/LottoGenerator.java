package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MAXIMUM_LOTTO_COUNT = 6;

    public LottoGroup generateLottos(int count) {
        return new LottoGroup(
                Stream.generate(this::generateRandomLottoNumber)
                        .limit(count)
                        .collect(Collectors.toList())
        );
    }

    public Lotto generateRandomLottoNumber() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_COUNT
                )
        );
    }
}
