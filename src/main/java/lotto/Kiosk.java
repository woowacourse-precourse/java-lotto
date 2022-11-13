package lotto;

import ExceptionCollections.CommonException;
import ExceptionCollections.PaymentException;
import View.Input;
import View.Output;

import java.util.List;

public class Kiosk {
    static protected List<Integer> winningNumbers;
    static protected int bonusNumber;
    static protected Integer[] resultStatistics = {0, 0, 0, 0, 0};
    static protected Buyer buyer;

    static public void start(Buyer buyer) {
        int payment = getPurchaseAmount();
    }

    static private int getPurchaseAmount() {
        Output.getPurchaseAmount();
        String payment = Input.getPurchaseMoney();
        PaymentException.validate(payment);
        return Integer.valueOf(payment);
    }

}
