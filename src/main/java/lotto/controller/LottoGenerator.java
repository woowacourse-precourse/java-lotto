package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }

    public static List<Lotto> generateUserLottoNumbers(int cnt) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int idx = 0; idx < cnt; idx++) {
            Lotto lotto = new Lotto(generateLottoNumber());
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }
}
