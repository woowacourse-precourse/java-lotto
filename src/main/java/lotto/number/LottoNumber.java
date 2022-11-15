package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LENGTH = 6;

    public List<List<Integer>> generateLottoNumber(int numberOfLotto) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }
}
