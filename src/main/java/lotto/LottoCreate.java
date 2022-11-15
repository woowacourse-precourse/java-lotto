package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCreate {

    private List<Integer> lottoNumbers;
    public LottoCreate() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
