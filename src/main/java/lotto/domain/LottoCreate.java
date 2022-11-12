package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCreate {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public List<Integer> createLottonum() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}
