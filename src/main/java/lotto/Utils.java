package lotto;

import java.util.List;

public class Utils {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    public static boolean validateLottoNumbers(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < START_NUMBER || n > END_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
