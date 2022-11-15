package lotto.exception;

import java.util.NoSuchElementException;
import lotto.domain.Constant;

public class UserException {


    public void checkUserExceptions(String userLottoPrice) {
        checkUserLottoPriceAboutOnlyNumbers(userLottoPrice);
        checkLottoPriceDividedByOneThousand(userLottoPrice);
    }



}
