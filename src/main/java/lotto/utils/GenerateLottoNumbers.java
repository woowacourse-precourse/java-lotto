package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumbers {
    final static int START_NUM = 1;
    final static int END_NUM = 45;
    final static int COUNT_NUM = 6;
    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
