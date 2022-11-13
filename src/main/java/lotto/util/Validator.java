package lotto.util;

import lotto.constant.Constant;

public class Validator {

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isLottoMoney(int money){
        return money % Constant.LOTTO_PRICE == 0;
    }

    public static boolean isNotComma(String inputWinningNumbers) {

        String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
        if (splitInputWinningNumbers.length != Constant.LOTTO_SIZE){
            return true;
        }

        return false;
    }
}
