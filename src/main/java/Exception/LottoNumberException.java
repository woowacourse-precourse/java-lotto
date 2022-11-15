package Exception;

import java.util.List;
import java.util.regex.Pattern;

public class LottoNumberException {
    private static final String NOTNUMBER_ERRORMESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String OUTOFRANGE_ERRORMESSAGE = "[ERROR] 1~45사이의 숫자만 입력해주세요.";
    private static final String WINNINGNUMBERCONTAINBONUSNUMBER_ERROMESSAGE = "[ERROR] 당첨번호에 보너스 번호가 포함되어 있습니다.";
    private static final String NUMERICAL_REGULAREXPRESSION = "^[0-9]*$";
    private static final int MAXIMUM_LOTTONUMBER = 45;
    private static final int MINIMUM_LOTTONUMBER = 1;

    public static void checkWinningNumberException(String number) {
        if (!Pattern.matches(NUMERICAL_REGULAREXPRESSION, String.valueOf(number))) {
            throw new IllegalArgumentException(NOTNUMBER_ERRORMESSAGE);
        }
        if (Integer.valueOf(number) < MINIMUM_LOTTONUMBER || Integer.valueOf(number) > MAXIMUM_LOTTONUMBER) {
            throw new IllegalArgumentException(OUTOFRANGE_ERRORMESSAGE);
        }
    }

    public static void checkBonusNumberException(String number, List<Integer> WinningNumbers) {
        if (!Pattern.matches(NUMERICAL_REGULAREXPRESSION, String.valueOf(number))) {
            throw new IllegalArgumentException(NOTNUMBER_ERRORMESSAGE);
        }
        if (Integer.valueOf(number) < MINIMUM_LOTTONUMBER || Integer.valueOf(number) > MAXIMUM_LOTTONUMBER) {
            throw new IllegalArgumentException(OUTOFRANGE_ERRORMESSAGE);
        }
        if (WinningNumbers.contains(Integer.valueOf(number))) {
            throw new IllegalArgumentException(WINNINGNUMBERCONTAINBONUSNUMBER_ERROMESSAGE);
        }
    }
}
