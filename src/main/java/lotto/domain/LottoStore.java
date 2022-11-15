package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    public static Lotteries buyLotto(Money money) {
        int lottoAmount = money.calculateLottoAmount();
        return new Lotteries(
                Stream.generate(LottoStore::makeLotto)
                        .limit(lottoAmount)
                        .collect(Collectors.toList()));
    }

    private static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
