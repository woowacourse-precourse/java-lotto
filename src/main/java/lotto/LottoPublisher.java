package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {
    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private final LottoMetadata lottoMetadata;

    public LottoPublisher(LottoMetadata lottoMetadata) {
        this.lottoMetadata = lottoMetadata;
    }

    List<Lotto> purchase(Integer num) {
        return purchaseMultipleLotto(num);
    }

    private List<Lotto> purchaseMultipleLotto(Integer num) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            lottos.add(purchaseOne());
        }
        return lottos;
    }

    private Lotto purchaseOne() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                lottoMetadata.getStartNumber(),
                lottoMetadata.getEndNumber(),
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }
}
