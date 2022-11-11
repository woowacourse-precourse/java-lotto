package lotto.infra.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomsLottoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generateByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(generateNumbers()))
                .collect(toList());
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
