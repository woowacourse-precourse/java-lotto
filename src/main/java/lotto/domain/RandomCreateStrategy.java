package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomCreateStrategy implements CreateStrategy {
    @Override
    public List<LottoNumber> createTempLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1,45,6)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
