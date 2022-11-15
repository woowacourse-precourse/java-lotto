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

    public Lotto purchase() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                lottoMetadata.getStartNumber(),
                lottoMetadata.getEndNumber(),
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }

    List<Lotto> purchase(Integer payment) {
        raiseErrorIfRemainderIsZero(payment, lottoMetadata.getPriceOfLotto());
        return purchaseMultipleLotto(payment);
    }

    private List<Lotto> purchaseMultipleLotto(Integer payment) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payment / lottoMetadata.getPriceOfLotto(); ++i) {
            lottos.add(purchase());
        }
        return lottos;
    }

    private void raiseErrorIfRemainderIsZero(Integer payment, Integer wonPerLotto) {
        if (payment % wonPerLotto != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 로또 가격으로 나누어 떨어지지 않습니다.");
        }
    }
}
