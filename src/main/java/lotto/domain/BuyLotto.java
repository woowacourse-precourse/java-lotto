package lotto.domain;

import lotto.exception.CheckMoneyCountException;
import lotto.exception.CheckThisNumException;

public class BuyLotto {
    public static final int MININUM_LOTTO_PURCHASE = 1000;

    public static Integer howMuchBuy(String inputHowMuch) {
        return howMuchStringToInt(inputHowMuch);
    }

    private static Integer howMuchStringToInt(String inputHowMuch) {
        checkThisNum(inputHowMuch);
        int howMuch = Integer.parseInt(inputHowMuch);
        checkHowMuchRange(howMuch);
        return howMuch;
    }

    private static void checkHowMuchRange(int howMuch) {
        if (howMuch % 1000 != 0)
            throw new CheckMoneyCountException();
    }

    private static void checkThisNum(String inputHowMuch) {
        if (isNumeric(inputHowMuch) == false)
            throw new CheckThisNumException();
    }

    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
