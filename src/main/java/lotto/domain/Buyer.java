package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.*;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer(String won) {
        int numberOfLottos = calculateNumberOfLottos(won);
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfLottos; count++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE));
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    private int calculateNumberOfLottos(String won) {
        int wonParseToInt = Integer.parseInt(won);
        validateIsUnderLottoPrice(wonParseToInt);
        int wonRoundDownLottoPriceUnits = roundDownLottoPriceUnits(wonParseToInt);
        return wonRoundDownLottoPriceUnits / LOTTO_PRICE;
    }

    private void validateIsUnderLottoPrice(int won) {
        if (won < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    private int roundDownLottoPriceUnits(int won) {
        return won - (won % LOTTO_PRICE);
    }
}
