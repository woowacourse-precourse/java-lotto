package lotto.util;

import static lotto.constant.Constant.ERROR_INTEGER;
import static lotto.constant.Constant.ERROR_MESSAGE;

public class InputUtil {
    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_INTEGER);
        }
        return -1;
    }
}
