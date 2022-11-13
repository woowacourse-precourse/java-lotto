package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.GameConstants.*;

public class Player {

    private void validateNaturalNumber(String purchaseAmount) {
        if (!Pattern.matches(NATURAL_NUMBER_REGEX, purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NATURAL_NUMBER_EXCEPTION.toString());
        }
    }
}