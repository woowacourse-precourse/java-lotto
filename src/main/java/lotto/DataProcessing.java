package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class DataProcessing {
    public List<Integer> lottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Integer> sortLottoNumbers() {
        List<Integer> sortNumber = lottoNumbers();
        Collections.sort(sortNumber);
        return sortNumber;
    }
}