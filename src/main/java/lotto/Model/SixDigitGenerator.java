package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import lotto.resources.Constants;

public class SixDigitGenerator {

    public static List<Lotto> generateLottoDigits(long lottoCnt) {
        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto createdLotto = new Lotto(selectLottoDigits());
            lottoSet.add(createdLotto);
        }
        return lottoSet;
    }

    public static List<Integer> selectLottoDigits() {
        List<Integer> generated = Randoms.pickUniqueNumbersInRange(Constants.FROM.getValue(), Constants.TO.getValue(),
                Constants.LOTTO_LENGTH.getValue());
        List newList = new ArrayList(generated);
        Collections.sort(newList);
        return newList;
    }
}
