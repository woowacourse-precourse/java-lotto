package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoNumbers.sort(Integer::compareTo);
        return lottoNumbers;
    }
}
