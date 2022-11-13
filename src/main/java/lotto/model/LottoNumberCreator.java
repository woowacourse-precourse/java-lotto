package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberCreator {

    public static List<Integer> createRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
