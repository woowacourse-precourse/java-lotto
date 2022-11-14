package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoUtils {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int NUMBER_COUNT = 6;
    final static String SEPARATOR = ",";
    public static List<Integer> pickUniqueNumbersInRange(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return numbers;
    }
}
