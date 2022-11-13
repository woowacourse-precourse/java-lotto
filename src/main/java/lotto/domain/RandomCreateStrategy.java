package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

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
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
