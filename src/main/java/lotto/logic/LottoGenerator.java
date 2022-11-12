package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private List<Integer> lottonum;

    public List<Integer> lottoGenerate() {
        lottonum = new ArrayList<>();
        lottonum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottonum);
        return lottonum;
    }
}
