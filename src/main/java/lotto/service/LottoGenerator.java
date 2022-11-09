package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> generateLotto() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNum);
        return lottoNum;
    }
}
