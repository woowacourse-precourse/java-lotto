package lotto.exception;

import java.util.NoSuchElementException;
import lotto.domain.Constant;

public class UserException {


    public void checkUserExceptions(String userLottoPrice) {
        checkUserLottoPriceAboutOnlyNumbers(userLottoPrice);
        checkLottoPriceDividedByOneThousand(userLottoPrice);
    }

    public void checkLottoPriceDividedByOneThousand(String userLottoPrice) {
        if ((Integer.parseInt(userLottoPrice)) % Constant.LOTTO_ONE_PRICE != 0
                || (Integer.parseInt(userLottoPrice)) == 0 || Integer.parseInt(userLottoPrice) < 0) {
            System.out.println(Constant.ERROR_MESSAGE + " 구매 단위는 1000으로 나누어 떨어져야 합니다. ");
            throw new NoSuchElementException();
        }
    }

    public static void checkUserLottoPriceAboutOnlyNumbers(String userLottoPrice) {
        for (int i = 0; i < userLottoPrice.length(); i++) {
            if (!Character.isDigit(userLottoPrice.charAt(i))) {
                System.out.println(Constant.ERROR_MESSAGE + "숫자만 입력이 가능합니다. ");
                throw new NoSuchElementException();
            }
        }
    }


}
