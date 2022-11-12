package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> startLottoGenerate(String userMoney) {
        int cnt = calculateLottoCount(userMoney);
        return generateUserLottoNumbers(cnt);
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumber);
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

    public static int calculateLottoCount(String userMoney) {
        return Integer.parseInt(userMoney)/1000;
    }
}
