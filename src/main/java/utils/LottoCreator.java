package utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT);
        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);

        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
