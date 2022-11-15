package lotto.util;

import static lotto.constant.Constant.ERROR_INTEGER;
import static lotto.constant.Constant.ERROR_MESSAGE;

public class InputUtil {
    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            ErrorUtil.throwError(ERROR_MESSAGE + ERROR_INTEGER);
            return -1;
        }
    }
}
