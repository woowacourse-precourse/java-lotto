package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersMaker {
    final static int START_INCLUSIVE = 1;
    final static int END_INCLUSIVE = 45;
    final static int LIMIT_SIZE = 6;

    public static List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LIMIT_SIZE);

        return lottoNumbers;
    }
}
