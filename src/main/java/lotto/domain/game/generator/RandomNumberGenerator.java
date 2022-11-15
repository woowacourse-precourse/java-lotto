package lotto.domain.game.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LottoConstants.*;
import static lotto.domain.lotto.LottoConstants.LOTTO_MIN_VALUE;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_VALUE.getNumber(),
                LOTTO_MAX_VALUE.getNumber(),
                LOTTO_SIZE.getNumber()
        );

        return integers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
