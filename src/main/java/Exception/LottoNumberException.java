package Exception;

import java.util.regex.Pattern;

public class LottoNumberException {
    private static final String NOTNUMBER_ERRORMESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String OUTOFRANGE_ERRORMESSAGE = "[ERROR] 1~45사이의 숫자만 입력해주세요.";

    public static void checkException(String number) {

        if (!Pattern.matches("^[1-9]*$", String.valueOf(number))) {
            throw new IllegalArgumentException(NOTNUMBER_ERRORMESSAGE);
        }
        if (Integer.valueOf(number) < 1 || Integer.valueOf(number) > 45) {
            throw new IllegalArgumentException(OUTOFRANGE_ERRORMESSAGE);
        }
    }
}
