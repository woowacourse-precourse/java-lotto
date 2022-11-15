package lotto.infra.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomsLottoGenerator implements LottoGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT = 6;
    private static final int ZERO = 0;

    @Override
    public List<Lotto> generateByCount(final int count) {
        return IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(generateNumbers()))
                .collect(toList());
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
    }
}
