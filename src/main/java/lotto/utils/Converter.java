package lotto.utils;

import static lotto.utils.Validation.validateIsNumber;


public class Converter {

    public static int stringToInt(String target) {
        validateIsNumber(target);
        return Integer.parseInt(target);
    }


}
