package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private final static int LOTTO_COUNT = 6;

    public List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_COUNT);
        List<Integer> modifiableLottoNumbers = new ArrayList<Integer>(lottoNumbers);
        Collections.sort(modifiableLottoNumbers);
        return modifiableLottoNumbers;
    }
}
