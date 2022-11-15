package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LENGTH = 6;

    public List<Lotto> generateLottoNumber(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto;
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lotto = new Lotto(lottoNumber);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
