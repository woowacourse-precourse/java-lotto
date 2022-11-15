package Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
    }

}

