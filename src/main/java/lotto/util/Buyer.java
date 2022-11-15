package lotto.util;

import lotto.enums.ErrorMessage;
import lotto.enums.Range;
import lotto.util.Validator;

public class Buyer {

    public static int getQuantity(int price) {
        validatePrice(price);
        return price / Range.PRICE.get();
    }

    public static int getIntPrice(String stringPrice) {
        Validator validator = new Validator();
        return validator.stringToInt(stringPrice);
    }

    public static boolean validatePrice(int price) {
        if (price % Range.PRICE.get() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR.getErrorMessage());
        }
        return true;
    }

}
