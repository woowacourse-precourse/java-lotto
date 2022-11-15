package lotto.domain;

import lotto.domain.exception.IllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Collections.sort;
import static lotto.domain.exception.ErrorType.ERROR_UNDER_LOTTO_PRICE;
import static lotto.domain.Lotto.*;

public class Buyer {
    private static final int COUNT_START_VALUE = 0;
    private final List<Lotto> lottos;

    public Buyer(int won) {
        int numberOfLottos = calculateNumberOfLottos(won);
        List<Lotto> lottos = new ArrayList<>();
        for (int count = COUNT_START_VALUE; count < numberOfLottos; count++) {
            List<Integer> lottoNumbers = new ArrayList<>(pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE));
            ascendingSort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    private int calculateNumberOfLottos(int won) {
        validateIsUnderLottoPrice(won);
        int wonRoundDownLottoPriceUnits = roundDownLottoPriceUnits(won);
        return wonRoundDownLottoPriceUnits / LOTTO_PRICE;
    }

    private void validateIsUnderLottoPrice(int won) {
        if (won < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_UNDER_LOTTO_PRICE.getErrorMessage());
        }
    }

    private int roundDownLottoPriceUnits(int won) {
        return won - (won % LOTTO_PRICE);
    }

    private void ascendingSort(List<Integer> lottoNumbers) {
        sort(lottoNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
