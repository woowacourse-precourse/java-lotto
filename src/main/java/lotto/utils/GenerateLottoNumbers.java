package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumbers {
    public final static int START_NUM = 1;
    public final static int END_NUM = 45;
    public final static int COUNT_NUM = 6;
    public static List<Integer> generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM));
        Collections.sort(numbers);
        return numbers;
    }
}
