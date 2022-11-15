package Exception;

import java.util.regex.Pattern;

public class PriceException {
    private static final String NOTNUMBER_ERRORMESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String PRICEUNIT_ERRORMESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력해주세요.";
    private static final String NUMERICAL_REGULAREXPRESSION = "^[0-9]*$";
    private static final int UNITOFPURCHASEAMOUNT = 1000;

    public static void checkException(String price) {
        if (!Pattern.matches(NUMERICAL_REGULAREXPRESSION, price)) {
            throw new IllegalArgumentException(NOTNUMBER_ERRORMESSAGE);
        }
        if (Integer.valueOf(price) % UNITOFPURCHASEAMOUNT != 0) {
            throw new IllegalArgumentException(PRICEUNIT_ERRORMESSAGE);
        }
    }
}
