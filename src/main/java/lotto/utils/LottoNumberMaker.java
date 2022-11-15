package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domains.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberMaker {
    private LottoNumberMaker(){}
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static Lotto createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                        START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
