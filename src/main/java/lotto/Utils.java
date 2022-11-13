package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;

    public static boolean validateLottoNumbers(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < START_NUMBER || n > END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> pickUnique6Numbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
    }
}
