package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    public LottoGenerator() {
    }

    public List<Lotto> generateLottoBundle(int money) {
        List<Lotto> lottoBundle = new ArrayList<>();
        int lottoCounts = money / LOTTO_PRICE;

        for (int count = 0; count < lottoCounts; count++) {
            Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_COUNT));
            lottoBundle.add(newLotto);
        }
        return lottoBundle;
    }
}