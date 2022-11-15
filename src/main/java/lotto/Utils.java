package lotto;

import static Constant.ErrorMessage.NOT_INTEGER;
import static Constant.Game.MAX_NUMBER;
import static Constant.Game.MIN_NUMBER;

public class Utils {
    Integer isNumeric(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    boolean invalidRange(Integer number) {
        return (number < MIN_NUMBER || number > MAX_NUMBER);
    }
}
