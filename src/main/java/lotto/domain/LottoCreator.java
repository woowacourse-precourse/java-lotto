package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {

    private static final int LOTTO_SIZE = 6;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public static List<Lotto> saveLotto(final int lottoQuantity) {
        List<Lotto> lottoContainer = new ArrayList<>();
        for (int currentSize = 0; currentSize < lottoQuantity; ++currentSize) {
            lottoContainer.add(createLotto());
        }
        return lottoContainer;
    }

    private static Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
