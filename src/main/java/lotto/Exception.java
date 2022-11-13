package lotto;

import static lotto.BonusInputException.*;
import static lotto.PaymentInputException.paymentChangeError;
import static lotto.PaymentInputException.paymentTypeError;
import static lotto.WinNumInputException.*;

public class Exception {

    public static void paymentInputCheck(String inputPayment) {
        paymentTypeError(inputPayment);
        StartLotto.payment = Integer.parseInt(inputPayment);
        paymentChangeError();
    }

    public static void winNumInputErrorCheck(String inputWinNums) {
        winNumFormatError(inputWinNums);
        String[] tmpWinNums = inputWinNums.split(",");
        winNumDuplicate(tmpWinNums);
        winNumSizeError(tmpWinNums);
        for (String e : tmpWinNums) {
            winNumTypeError(e);
            int num = Integer.parseInt(e);
            winNumRangeError(num);
        }
    }

    public static void bonusErrorCheck(String inputBonusNum) {
        bonusTypeError(inputBonusNum);
        StartLotto.bonusNum = Integer.parseInt(inputBonusNum);
        bonusRangeError();
        bonusDuplicate();
    }

}
