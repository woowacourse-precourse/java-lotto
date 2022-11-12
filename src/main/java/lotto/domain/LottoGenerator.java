package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    private static int lottoMinNumber = 1;
    private static int lottoMaxNumber = 45;
    private static int lottoSize = 6;

    private LottoGenerator() {}

    public static Lotto getRandomLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(lottoMinNumber, lottoMaxNumber, lottoSize);
        return new Lotto(lottoNumbers);
    }
}