package lotto.domain;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_TYPE_ERROR;
import static lotto.constant.InputPattern.PURCHASE_AMOUNT_PATTERN;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class CheckInput {

    public void checkInputAmountPattern(String input) {
        Pattern pattern = Pattern.compile(PURCHASE_AMOUNT_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TYPE_ERROR);
        }
    }

}
