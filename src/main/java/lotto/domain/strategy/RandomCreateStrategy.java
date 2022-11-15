package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoNumber;
import lotto.domain.strategy.CreateStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RandomCreateStrategy implements CreateStrategy {
    private static final int MIN = 1;
    public static final int MAX = 45;
    public static final int LIMIT = 6;

    @Override
    public List<LottoNumber> createTempLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, LIMIT)
                .stream()
                .map(LottoNumber::lottoNumber)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }
}
