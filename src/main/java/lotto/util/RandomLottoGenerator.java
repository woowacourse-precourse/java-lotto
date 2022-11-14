package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.model.Lotto;
import lotto.model.Money;

public class RandomLottoGenerator {

    public static List<Lotto> getRandomLottos(Money money, int lottoLength) {
        List<Lotto> lottos = LongStream.range(0, money.getPayLottos())
                .mapToObj(idx -> Randoms.pickUniqueNumbersInRange(LottoValueRange.MIN,
                        LottoValueRange.MAX, lottoLength))
                .map((randomLottoNumbers) -> new Lotto(randomLottoNumbers, lottoLength))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(lottos);
    }
}
