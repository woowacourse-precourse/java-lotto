package lotto.Utils;

import lotto.Constant.Message;

public class Convert {

    public static int StrToInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER.getMessage());
        }
    }
}
