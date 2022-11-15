package lotto.exception;

import java.util.Arrays;
import java.util.HashSet;
import static lotto.constant.Constant.*;
import java.util.NoSuchElementException;
import java.util.Set;

public class UserInputLottoInfoException {
    public void isInputValueOnlyNumber(String price, String message) {
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                System.out.println(ERROR_MESSAGE + message);
                throw new NoSuchElementException();
            }
        }
    }
}
