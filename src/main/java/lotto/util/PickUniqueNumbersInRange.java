package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class PickUniqueNumbersInRange {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int NUMBER_COUNT = 6;
    public static List<Integer> getNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return numbers;
    }
}
